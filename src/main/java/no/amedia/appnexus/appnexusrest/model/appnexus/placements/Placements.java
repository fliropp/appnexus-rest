package no.amedia.appnexus.appnexusrest.model.appnexus.placements;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Placements {

  private List<Placement> placements;

  private Placement placement;
}
