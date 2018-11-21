package no.amedia.appnexus.appnexusrest.model.appnexus.contentcategory;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContentCategory {
  private Long id;
  private String name;
  private String action;
}
