package org.alexr.web.filters;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import javax.servlet.DispatcherType;
import java.util.EnumSet;

/**
 * servlet located at:
 * http://localhost:9002/c?x=3
 * http://localhost:9002/c?x=2&y=3
 */
public class App2Solution {
  public static void main(String[] args) throws Exception {
    ServletContextHandler handler = new ServletContextHandler();
    handler.addServlet(ServletGoodDesign.class, "/c/*");
    handler.addFilter(ParamsFilter.class, "/c/*", EnumSet.of(DispatcherType.REQUEST));

    Server server = new Server(9002);
    server.setHandler(handler);
    server.start();;
    server.join();
  }
}
