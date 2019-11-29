package org.alexr.web.cookies;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * localhost:9001/a/1/2/3/4/5?x=5&y=+++
 */
public class CookieServletA extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    Cookie cookie = new Cookie("%A", "123");
//    cookie.setMaxAge(20); // in seconds
    resp.addCookie(cookie);
    try (PrintWriter w = resp.getWriter()) {
      w.printf("getProtocol:%s\ngetServerName:%s\ngetServerPort%s\n" +
              "getServletPath:%s\ngetContextPath: %s\n" +
              "getPathInfo:%s\ngetQueryString:%s\n" +
              "getRequestURL:%s\ngetRequestURI:%s\n" +
              "%s",
          req.getProtocol(),    //  HTTP/1.1
          req.getServerName(),  //  localhost
          req.getServerPort(),  //  9001

          req.getServletPath(), //  /a
          req.getContextPath(), //  EMPTY

          req.getPathInfo(),    //  /1/2/3/4/5 - all between servlet mapping "/a" and parameters or NULL
          req.getQueryString(), //  x=5&y=+++ or NULL

          req.getRequestURL(),  //  http://localhost:9001/a/1/2/3/4/5
          req.getRequestURI(),  //  /a/1/2/3/4/5
          ""
      );
    }
  }
}
