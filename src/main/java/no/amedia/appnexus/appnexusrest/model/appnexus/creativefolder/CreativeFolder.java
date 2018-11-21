package no.amedia.appnexus.appnexusrest.model.appnexus.creativefolder;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import no.amedia.appnexus.appnexusrest.model.appnexus.creative.Creative;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreativeFolder {
  private Long id;
  private String name;
  private Long advertiser_id;
  private List<Creative> creatives;
}
