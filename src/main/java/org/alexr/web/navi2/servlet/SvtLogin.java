package org.alexr.web.navi2.servlet;

import org.alexr.web.freemarker.TemplateEngine;
import org.alexr.web.service.Auth;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SvtLogin extends HttpServlet {

  private final TemplateEngine te;
  private final Auth auth;

  public SvtLogin(TemplateEngine te, Auth auth) {
    this.te = te;
    this.auth = auth;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HashMap<String, Object> data = new HashMap<>();

    data.put("header", "This is login page");
    data.put("links", LinkItem.allLinks());
    te.render("login.ftl", data, resp);
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String u_name = req.getParameter("u_name");
    String u_password = req.getParameter("u_password");

    Map<String, Object> data = new HashMap<>();
    data.put("links", LinkItem.allLinks());
    data.put("header", "Login result");

    if (auth.check(u_name, u_password)) {
      data.put("name", u_name);
      te.render("login-ok.ftl", data, resp);
    } else {
      te.render("login-err.ftl", data, resp);
    }
  }
}
