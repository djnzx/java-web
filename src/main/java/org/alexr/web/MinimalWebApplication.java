package org.alexr.web;

import org.alexr.web.servlet.HelloServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class MinimalWebApplication {
  public static void main(String[] args) throws Exception {
    Server server = new Server(9001);

    ServletContextHandler handler = new ServletContextHandler();

    handler.addServlet(HelloServlet.class, "/*");

    server.setHandler(handler);
    server.start();;
    server.join();
  }
}
