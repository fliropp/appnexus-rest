package no.amedia.appnexus.appnexusrest.model.appnexus.authentication;

/**
 * Created by fdani on 09.10.2018.
 */
public class AuthenticationHolder {

  private static ThreadLocal<Authentication> authenticationThreadLocal = new ThreadLocal<>();

  public static void setAuth(Authentication auth) {
    authenticationThreadLocal.set(auth);
  }

  public static String getToken() {
    return authenticationThreadLocal.get().getToken();
  }
}
