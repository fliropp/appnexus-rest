package no.amedia.appnexus.appnexusrest.model.appnexus.lineitem;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LineItemRequest {

  @JsonProperty("line-item")
  private LineItem lineItem;
}
