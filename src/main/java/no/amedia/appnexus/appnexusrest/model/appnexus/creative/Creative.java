package no.amedia.appnexus.appnexusrest.model.appnexus.creative;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import no.amedia.appnexus.appnexusrest.model.appnexus.template.CreativeTemplate;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Creative {
  private Long id;
  private String name;
  private String original_content;
  private String original_content_secure;
  private String content;
  private String content_secure;
  private Integer width;
  private Integer height;
  private CreativeTemplate template;
  private Long advertiser_id;
}
