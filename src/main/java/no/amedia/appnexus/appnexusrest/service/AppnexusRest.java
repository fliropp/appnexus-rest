package no.amedia.appnexus.appnexusrest.service;

import no.amedia.appnexus.appnexusrest.model.appnexus.template.CreativeTemplate;
import no.amedia.appnexus.appnexusrest.model.appnexus.template.Macro;
import no.amedia.appnexus.appnexusrest.model.appnexus.template.ResponseCreativeTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;

@Service
public class AppnexusRest {

    @Autowired
    AppnexusAuth appnexusAuth;

    @Value("${appnexus.url}")
    String appnexusUrl;


    public CreativeTemplate getTemplate(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<ResponseCreativeTemplate> exchange =
                restTemplate.exchange(appnexusUrl + "template?id=" + id, HttpMethod.GET, appnexusAuth.createAuthHeader(), ResponseCreativeTemplate.class);
        System.out.println(exchange);
        return exchange.getBody().getResponse().getCreativeTemplate();
    }

    public void createTemplate(String templateMarkup, ArrayList<Macro> macros) {
        RestTemplate restTemplate = new RestTemplate();
        TemplateRequest templateRequest = new TemplateRequest();
        Template template = new Template();
        templateRequest.setTemplate(template);
        template.setName("Spray Ad Template #2");
        Format format = new Format();
        format.setId(7L);
        template.setFormat(format);
        MediaSubType media_subtype = new MediaSubType();
        media_subtype.setId(1L);
        template.setMedia_subtype(media_subtype);
        template.setContent_html(templateMarkup);
        template.setMacros(macros);


        ResponseEntity<Object> exchange =
                restTemplate.exchange(appnexusUrl + "template", HttpMethod.POST, appnexusAuth.createAuthHeader(templateRequest), Object.class);
        System.out.println(exchange);
    }



    public void updateTemplate(String templateId, String content, Format.Type formatType, MediaSubType.Type bannerType, ArrayList<Macro> macros) {
        RestTemplate restTemplate = new RestTemplate();
        TemplateRequest templateRequest = new TemplateRequest();
        Template template = new Template();
        template.setContent_html(content);
        MediaSubType media_subtype = new MediaSubType();
        media_subtype.setId(bannerType.getId());
        template.setMedia_subtype(media_subtype);
        Format format = new Format();
        format.setId(formatType.getId());
        template.setFormat(format);
        template.setName("Spray Ad CM");
        //template.setMacros(macros);
        templateRequest.setTemplate(template);

        ResponseEntity<Object> exchange =
                restTemplate.exchange(
                        appnexusUrl + "template?id=" + templateId,
                        HttpMethod.PUT, appnexusAuth.createAuthHeader(templateRequest), Object.class
                );
        System.out.println(exchange);
    }




}
