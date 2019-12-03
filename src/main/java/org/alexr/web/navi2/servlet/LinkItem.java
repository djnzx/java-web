package org.alexr.web.navi2.servlet;

import java.util.Arrays;
import java.util.List;

public class LinkItem {
  private final String href;
  private final String name;

  public LinkItem(String href, String name) {
    this.href = href;
    this.name = name;
  }

  public String getHref() {
    return href;
  }

  public String getName() {
    return name;
  }

  public static List<LinkItem> allLinks() {
    return Arrays.asList(
        new LinkItem("/login", "Login"),
        new LinkItem("/logout", "Logout"),
        new LinkItem("/menu", "Menu"),
        new LinkItem("/calc", "Calc"),
        new LinkItem("/history", "History"),
        new LinkItem("http://www.google.com", "Google")
    );
  }
}
