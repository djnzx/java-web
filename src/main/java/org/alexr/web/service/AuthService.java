package org.alexr.web.service;

import java.util.HashMap;
import java.util.Map;

public class AuthService implements Auth {
  Map<String, String> data = new HashMap<>();

  public AuthService() {
    data.put("user","123");
    data.put("admin","567");
  }

  @Override
  public boolean check(String login, String paswd) {
    return data.containsKey(login)
        && data.get(login).equals(paswd);
  }

}
