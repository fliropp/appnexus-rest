package no.amedia.appnexus.appnexusrest.service;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import no.amedia.appnexus.appnexusrest.model.appnexus.report.Report;
import no.amedia.appnexus.appnexusrest.model.appnexus.report.createreport.CreateReport;
import no.amedia.appnexus.appnexusrest.model.appnexus.report.createreport.CreateReportResponse;
import no.amedia.appnexus.appnexusrest.model.appnexus.report.createreport.RequestCreateReport;
import no.amedia.appnexus.appnexusrest.model.appnexus.report.createreport.ResponseCreateReport;
import no.amedia.appnexus.appnexusrest.model.appnexus.report.reportstatus.ResponseStatusReport;
import no.amedia.appnexus.appnexusrest.model.appnexus.report.reportstatus.StatusReportResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.*;

public class AppnexusReporting {

    @Autowired
    AppnexusAuth appnexusAuth;

    @Value("${appnexus.url}")
    String appnexusUrl;

    public List<Report> generateReport(CreateReport createReport, String publisher){
        List<Report> reports = generateReport(createReport);
        List<Report> reportsByPublisher = new ArrayList<>();
        for (Report report : reports) {
            if(report.getPublisherName().toLowerCase().contains(publisher)) {
                reportsByPublisher.add(report);
            }
        }
        return reportsByPublisher;
    }

    public List<Report>generateReport(CreateReport createReport){

        List<Report> report = null;
        CreateReportResponse create =  this.requestReport(createReport);
        StatusReportResponse status = null;
        if(create.getStatus().equalsIgnoreCase("ok")) {
            status = this.probeReportStatus(create.getReportId());
            while(! status.getExecutionStatus().equals("ready")) {
                status = this.probeReportStatus(create.getReportId());
                System.out.println("status: " + status.getExecutionStatus());
            }
            report = this.downloadReport(status.getReport().getUrl());
        }
        return report;

    }


    private CreateReportResponse requestReport(CreateReport createReport) {
        appnexusAuth.authorize();
        RestTemplate restTemplate = new RestTemplate();
        RequestCreateReport requestCreateReport = new RequestCreateReport();
        createReport.setReportType("network_analytics");
        createReport.setColumns(new ArrayList<String>(
                Arrays.asList("hour", "seller_member_name", "buyer_member_name", "advertiser_name",
                        "publisher_name", "imps", "view_measured_imps", "imps_viewed", "view_rate",
                        "clicks", "total_convs", "ctr", "convs_rate", "placement_id", "placement_name",
                        "creative_id", "creative_name")));
        createReport.setFormat("csv");
        requestCreateReport.setCreateReport(createReport);
        ResponseEntity<ResponseCreateReport> exchange =
                restTemplate.exchange(appnexusUrl + "report", HttpMethod.POST,
                        appnexusAuth.createAuthHeader(requestCreateReport), ResponseCreateReport.class);
        return exchange.getBody().getResponse();

    }


    private StatusReportResponse probeReportStatus(String reportId){
       appnexusAuth.authorize();
       RestTemplate restTemplate = new RestTemplate();
       ResponseEntity<ResponseStatusReport> exchange =
               restTemplate.exchange(appnexusUrl + "report?id=" + reportId, HttpMethod.GET,
                       appnexusAuth.createAuthHeader(), ResponseStatusReport.class);

       return exchange.getBody().getResponse();
    }

    private List<Report> downloadReport(String url) {
        appnexusAuth.authorize();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> exchange =
                restTemplate.exchange(appnexusUrl + url, HttpMethod.GET,
                        appnexusAuth.createAuthHeader(), String.class);
        List<Report> reportData = loadObjectList(Report.class, exchange.getBody());
        return reportData;

    }

    private <T> List<T> loadObjectList(Class<T> type, String csvData) {
        try {
            writeStringToFile(csvData);
            CsvMapper csvMapper = new CsvMapper();
            csvMapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);
            CsvSchema csvSchema = csvMapper.typedSchemaFor(Report.class).withHeader();
            File file = new File(new ClassPathResource("test.csv").getFilename());
            List list = new CsvMapper().readerFor(Report.class)
                    .with(csvSchema.withColumnSeparator(CsvSchema.DEFAULT_COLUMN_SEPARATOR))
                    .readValues(file)
            .readAll();
            return list;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

    private void writeStringToFile(String str) {
        BufferedWriter bufferedWriter = null;
        try {
            File myFile = new File(new ClassPathResource("test.csv").getFilename());
            // check if file exist, otherwise create the file before writing
            if (!myFile.exists()) {
                myFile.createNewFile();
            }
            Writer writer = new FileWriter(myFile);
            bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try{
                if(bufferedWriter != null) bufferedWriter.close();
            } catch(Exception ex){

            }
        }
    }

}
