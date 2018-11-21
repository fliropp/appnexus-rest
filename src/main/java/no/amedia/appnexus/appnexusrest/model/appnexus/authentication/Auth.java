package no.amedia.appnexus.appnexusrest.model.appnexus.authentication;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Auth {
  private String username;
  private String password;
}
