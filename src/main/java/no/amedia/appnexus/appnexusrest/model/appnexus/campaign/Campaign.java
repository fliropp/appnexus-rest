package no.amedia.appnexus.appnexusrest.model.appnexus.campaign;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Campaign {
  private Long id;
  private Long advertiser_id;
  private Long line_item_id;
  private String name;
  private String cpm_bid_type;
  private String bid_margin;
  private Long profile_id;
}
