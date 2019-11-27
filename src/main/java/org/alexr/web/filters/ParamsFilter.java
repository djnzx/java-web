package org.alexr.web.filters;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ParamsFilter implements Filter {
  @Override
  public void init(FilterConfig filterConfig) { }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    String xs = request.getParameter("x");
    String ys = request.getParameter("x");
    try {
      int x = Integer.parseInt(xs);
      int y = Integer.parseInt(ys);
      // extra checks, extra if...

      // if everything is OK - pass forward
      chain.doFilter(request, response);
    } catch (NumberFormatException ex) {
      // in another case
      response.getWriter().println("smt went wrong");
      if (response instanceof HttpServletResponse) {
        HttpServletResponse rs = (HttpServletResponse) response;
        // or even...
//        rs.sendRedirect("https://www.google.com");
      }
    }
  }

  @Override
  public void destroy() {}
}
