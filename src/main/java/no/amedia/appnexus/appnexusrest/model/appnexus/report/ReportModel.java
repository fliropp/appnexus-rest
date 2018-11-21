package no.amedia.appnexus.appnexusrest.model.appnexus.report;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import no.amedia.appnexus.appnexusrest.model.appnexus.report.createreport.CreateReport;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ReportModel {

    String publisher;
    CreateReport createReport;
}
