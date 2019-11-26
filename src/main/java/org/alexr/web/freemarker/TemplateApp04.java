package org.alexr.web.freemarker;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * servlet location:
 * http://localhost:9004/fm4
 */
public class TemplateApp04 {
  public static void main(String[] args) throws Exception {
    TemplateEngine engine = TemplateEngine.resources("/template");

    ServletContextHandler handler = new ServletContextHandler();
    handler.addServlet(new ServletHolder(new FreemarkerServlet04(engine)), "/fm4/*");

    Server server = new Server(9004);
    server.setHandler(handler);
    server.start();
    server.join();
  }
}
