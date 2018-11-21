package no.amedia.appnexus.appnexusrest.model.appnexus.report.createreport;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;


@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateReport {
    @JsonProperty("report_type")
    private String reportType;
    private ArrayList<String> columns;
    @JsonProperty("report_interval")
    private String reportInterval;
    private String format;
}


