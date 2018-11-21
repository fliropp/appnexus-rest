package no.amedia.appnexus.appnexusrest.model.appnexus.placements;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import no.amedia.appnexus.appnexusrest.model.appnexus.contentcategory.ContentCategory;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Placement {

  private Long id;
  private String name;
  private String code;

  private List<ContentCategory> content_categories;
}
