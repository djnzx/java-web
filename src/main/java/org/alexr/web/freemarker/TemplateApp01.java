package org.alexr.web.freemarker;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
 * servlet location:
 * http://localhost:9001/ph1
 */
public class TemplateApp01 {
  public static void main(String[] args) throws Exception {
    ServletContextHandler handler = new ServletContextHandler();
    handler.addServlet(PlaceHolderServlet.class, "/ph1/*");

    Server server = new Server(9001);
    server.setHandler(handler);
    server.start();
    server.join();
  }
}
