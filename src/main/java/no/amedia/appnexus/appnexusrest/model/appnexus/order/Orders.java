package no.amedia.appnexus.appnexusrest.model.appnexus.order;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Orders {

  @JsonProperty("insertion-orders")
  private List<Order> orders;

  @JsonProperty("insertion-order")
  private Order order;
}
