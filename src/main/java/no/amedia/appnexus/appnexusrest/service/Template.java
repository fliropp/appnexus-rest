package no.amedia.appnexus.appnexusrest.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import no.amedia.appnexus.appnexusrest.model.appnexus.template.Macro;

import java.util.ArrayList;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown=true)
public class Template {
  private String name;
  private String content_html;
  private String content_js;
  private MediaSubType media_subtype;
  private Format format;
  private ArrayList<Macro> macros;
}
