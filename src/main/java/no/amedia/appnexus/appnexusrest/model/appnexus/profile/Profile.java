package no.amedia.appnexus.appnexusrest.model.appnexus.profile;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import no.amedia.appnexus.appnexusrest.model.appnexus.contentcategory.ContentCategoryTargets;
import no.amedia.appnexus.appnexusrest.model.appnexus.keyvalue.KeyValueTargets;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Profile {
  private Long id;
  private Long advertiser_id;
  private KeyValueTargets key_value_targets;
  private ContentCategoryTargets content_category_targets;
}
