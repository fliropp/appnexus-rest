package no.amedia.appnexus.appnexusrest.service;

import no.amedia.appnexus.appnexusrest.model.appnexus.authentication.Auth;
import no.amedia.appnexus.appnexusrest.model.appnexus.authentication.AuthReq;
import no.amedia.appnexus.appnexusrest.model.appnexus.authentication.AuthenticationHolder;
import no.amedia.appnexus.appnexusrest.model.appnexus.authentication.ResponseAuth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;

public class AppnexusAuth {

    @Value("${appnexus.url}")
    String appnexusUrl;

    @Value("${appnexus.usr}")
    String usr;

    @Value("${appnexus.pwd}")
    String pwd;



    public void authorize() {
        RestTemplate restTemplate = new RestTemplate();


        HttpEntity<AuthReq> request = new HttpEntity<AuthReq>(AuthReq
                .builder()
                .auth(Auth.builder().username(usr).password(pwd).build())
                .build());
        ResponseAuth auth = restTemplate.postForObject(appnexusUrl + "auth", request, ResponseAuth.class);
        System.out.println(auth);
        AuthenticationHolder.setAuth(auth.getResponse());
    }

    public HttpEntity<String> createAuthHeader() {
        return createAuthHeader("parameters");
    }

    public <T> HttpEntity<T> createAuthHeader(T v) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setAccept(Arrays.asList(MediaType.TEXT_PLAIN));
        headers.add("Authorization", AuthenticationHolder.getToken());

        HttpEntity<T> entity = new HttpEntity<>(v, headers);
        return entity;
    }

    public String getToken() {
        return AuthenticationHolder.getToken();
    }
}
