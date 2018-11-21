package no.amedia.appnexus.appnexusrest.model.appnexus.template;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreativeTemplateRequest {
  @JsonProperty("template")
  private CreativeTemplate creativeTemplate;
}
