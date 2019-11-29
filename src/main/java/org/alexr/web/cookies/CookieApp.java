package org.alexr.web.cookies;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
 * http://localhost:9001/a
 */
public class CookieApp {
  public static void main(String[] args) throws Exception {
    ServletContextHandler handler = new ServletContextHandler();

    handler.addServlet(CookieServletA.class, "/a/*");
    handler.addServlet(CookieServletB.class, "/b/*");

    Server server = new Server(9001);
    server.setHandler(handler);
    server.start();;
    server.join();
  }
}
