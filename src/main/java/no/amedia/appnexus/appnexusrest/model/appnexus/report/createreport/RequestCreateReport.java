package no.amedia.appnexus.appnexusrest.model.appnexus.report.createreport;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import no.amedia.appnexus.appnexusrest.model.appnexus.AppNexusRequest;

@Getter
@Setter
public class RequestCreateReport extends AppNexusRequest {
    @JsonProperty("report")
    private CreateReport createReport;
}
