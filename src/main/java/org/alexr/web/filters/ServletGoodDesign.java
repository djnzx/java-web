package org.alexr.web.filters;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ServletGoodDesign extends HttpServlet {
  /**
   * the solution:
   * Filter usage
   * but don't forget to attach the filter to our server
   */
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    int x = Integer.parseInt(req.getParameter("x"));
    int y = Integer.parseInt(req.getParameter("y"));
    int z = x + y;
    resp.getWriter().print(z);
  }
}
