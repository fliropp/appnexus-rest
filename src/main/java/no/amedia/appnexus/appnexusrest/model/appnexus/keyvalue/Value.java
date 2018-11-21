package no.amedia.appnexus.appnexusrest.model.appnexus.keyvalue;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Value {
  private String typ;
  private String key;
  private String vtp;
  private List<String> vsa;
  private List<ValueHolder> sbe;
}
