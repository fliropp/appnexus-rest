package no.amedia.appnexus.appnexusrest.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown=true)
public class MediaSubType {

  private Long id;

  public enum Type {
    BANNER (1L);

    private final Long id;

    Type(Long typeId) {
      this.id = typeId;
    }

    public Long getId() {
      return id;
    }
  }
}
