package no.amedia.appnexus.appnexusrest.model.appnexus.template;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Macro {

    String code;
    String name;
    String type;
    boolean isRequired;
    String defaultValue;
    String otherData;

}