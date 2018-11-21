package no.amedia.appnexus.appnexusrest.model.appnexus.template;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreativeTemplate {
  private Long id;
  private String name;
  private Long media_subtype_id;
  private Long format_id;
  private String ad_type;
  private String content_html;
  private ArrayList<Macro> macros;
}
