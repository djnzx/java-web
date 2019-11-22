package org.alexr.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletRedirect extends HttpServlet {
  private final String redirectTo;

  public ServletRedirect(String redirectTo) {
    this.redirectTo = redirectTo;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println(req.getPathInfo());
    // not the folder/file
    // but the URL!
    resp.sendRedirect(redirectTo);
  }
}
