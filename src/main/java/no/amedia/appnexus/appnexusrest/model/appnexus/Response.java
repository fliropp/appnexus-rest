package no.amedia.appnexus.appnexusrest.model.appnexus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response<T> {
  private T response;
}
