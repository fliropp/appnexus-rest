package no.amedia.appnexus.appnexusrest.model.appnexus.lineitem;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LineItems {

  @JsonProperty("line-items")
  private List<LineItem> lineItems;

  @JsonProperty("line-item")
  private LineItem lineItem;

}
