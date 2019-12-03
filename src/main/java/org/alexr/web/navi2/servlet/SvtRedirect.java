package org.alexr.web.navi2.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SvtRedirect extends HttpServlet {

  private final String redirectTo;

  public SvtRedirect(String redirectTo) {
    this.redirectTo = redirectTo;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.sendRedirect(redirectTo);
  }
}
