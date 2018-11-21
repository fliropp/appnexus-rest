package no.amedia.appnexus.appnexusrest.model.appnexus.lineitem;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import no.amedia.appnexus.appnexusrest.model.appnexus.creative.Creative;
import no.amedia.appnexus.appnexusrest.model.appnexus.order.Order;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LineItem {

  private Long id;
  private Long advertiser_id;
  private String name;
  private String creative_distribution_type;

  private Long profile_id;
  private List<Order> insertion_orders;
  private List<Creative> creatives;
  private String revenue_value;
  private String revenue_type;
  private Boolean manage_creative;
}
