package no.amedia.appnexus.appnexusrest.model.appnexus.creativefolder;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreativeFolderRequest {
  @JsonProperty("creative-folder")
  private CreativeFolder creativeFolder;
}
