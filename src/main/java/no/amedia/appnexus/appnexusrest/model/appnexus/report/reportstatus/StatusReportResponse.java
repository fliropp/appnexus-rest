package no.amedia.appnexus.appnexusrest.model.appnexus.report.reportstatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatusReportResponse {

    String status;
    StatusReport report;
    @JsonProperty("execution_status")
    String executionStatus;
}
