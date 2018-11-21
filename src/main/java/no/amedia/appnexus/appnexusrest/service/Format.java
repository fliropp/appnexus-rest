package no.amedia.appnexus.appnexusrest.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown=true)
public class Format {

  private Long id;

  public enum Type {
    RAW_JS (5L),
    RAW_HTML (6L),
    IFRAME_HTML (7L);

    private final Long id;

    Type(Long typeId) {
      this.id = typeId;
    }

    public Long getId() {
      return id;
    }
  }
}
