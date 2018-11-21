package no.amedia.appnexus.appnexusrest.model.appnexus.contentcategory;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContentCategoryTargets {
  private List<ContentCategory> content_categories;
}
