package no.amedia.appnexus.appnexusrest.model.appnexus.creative;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreativeRequest {
  private Creative creative;

  private List<Creative> creatives;
}
