package org.alexr.web.filters;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
 * servlet located at:
 * http://localhost:9001/c?x=2
 * http://localhost:9001/c?x=2&y=3
 */
public class App1Problem {
  public static void main(String[] args) throws Exception {
    ServletContextHandler handler = new ServletContextHandler();
    handler.addServlet(ServletNastyDesign.class, "/c/*");

    Server server = new Server(9001);
    server.setHandler(handler);
    server.start();;
    server.join();
  }
}
