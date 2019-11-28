package org.alexr.web.navi;

import org.alexr.web.freemarker.TemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class LoginServlet extends HttpServlet {

  private final TemplateEngine te;

  public LoginServlet(TemplateEngine te) {
    this.te = te;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HashMap<String, Object> data = new HashMap<>();

    data.put("header", "This is a login page");
    data.put("links", Arrays.asList(
        new LinkItem("/menu", "Menu"),
        new LinkItem("/logout", "Logout"),
        new LinkItem("http://google.com", "Google")
    ));
    te.render("navi.ftl", data, resp);
  }
}
