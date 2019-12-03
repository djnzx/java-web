package org.alexr.web.navi2.servlet;

import org.alexr.web.freemarker.TemplateEngine;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class SvtLogout extends HttpServlet {

  private final TemplateEngine te;

  public SvtLogout(TemplateEngine te) {
    this.te = te;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HashMap<String, Object> data = new HashMap<>();

    data.put("header", "This is a logout page");
    data.put("links", LinkItem.allLinks());
    te.render("navi.ftl", data, resp);
  }
}
