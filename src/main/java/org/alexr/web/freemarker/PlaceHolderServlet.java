package org.alexr.web.freemarker;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class PlaceHolderServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String name = "Jim";
    int number = 43;
    BufferedReader br = new BufferedReader(new FileReader(new File("./content/template/template.html")));
    try(PrintWriter w = resp.getWriter()) {
      br.lines().forEach(s -> {
        s = s.replaceAll("\\$user", name);
        s = s.replaceAll("\\$count", String.valueOf(number));
        w.println(s);
      });
    }
  }
}
