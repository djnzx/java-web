package org.alexr.web.cookies;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServletB extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
    Cookie cookie = new Cookie("%B", "123");
//    cookie.setMaxAge(20); // in seconds
    resp.addCookie(cookie);
  }
}
