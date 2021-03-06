package no.amedia.appnexus.appnexusrest.model.appnexus.keyvalue;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class KeyValueTargets {
  private KeyValueExpression kv_expression;
}
