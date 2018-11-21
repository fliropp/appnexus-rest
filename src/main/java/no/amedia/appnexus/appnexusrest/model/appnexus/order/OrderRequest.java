package no.amedia.appnexus.appnexusrest.model.appnexus.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {

  @JsonProperty("insertion-order")
  private Order order;
}
