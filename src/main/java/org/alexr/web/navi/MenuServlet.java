package org.alexr.web.navi;

import org.alexr.web.freemarker.TemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class MenuServlet extends HttpServlet {

  private final TemplateEngine te;

  public MenuServlet(TemplateEngine te) {
    this.te = te;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HashMap<String, Object> data = new HashMap<>();

    data.put("header", "This is menu");
    data.put("links", Arrays.asList(
        new LinkItem("/login", "Login"),
        new LinkItem("/logout", "Logout")
    ));
    te.render("navi.ftl", data, resp);
  }
}
