package org.alexr.web.filters;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletNastyDesign extends HttpServlet {
  /**
   * the problem:
   * we have to do a lot of checking stuff to do in each servlet
   * BEFOREHAND real operation
   */
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String xs = req.getParameter("x");
    String ys = req.getParameter("y");
    if (xs != null && ys != null) { // and so on...........
      try {
        int x = Integer.parseInt(xs);
        int y = Integer.parseInt(ys);
        int z = x + y;
        PrintWriter w = resp.getWriter();
        w.println(z);
      } catch (NumberFormatException ex) {
      }
    }
  }
}
