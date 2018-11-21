package no.amedia.appnexus.appnexusrest.model.appnexus.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order {

  public Long id;
  public Long advertiser_id;
  private String name;
}
