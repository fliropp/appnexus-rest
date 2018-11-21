package no.amedia.appnexus.appnexusrest.model.appnexus;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppNexusRequest {
    private String error_id;
    private String error;
    private String error_code;
}
