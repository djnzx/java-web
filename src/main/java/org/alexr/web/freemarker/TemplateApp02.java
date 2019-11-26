package org.alexr.web.freemarker;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * servlet location:
 * http://localhost:9002/fm2
 */
public class TemplateApp02 {
  public static void main(String[] args) throws Exception {
    TemplateEngine engine = TemplateEngine.folder("./content/template");

    ServletContextHandler handler = new ServletContextHandler();
    handler.addServlet(new ServletHolder(new FreemarkerServlet02(engine)), "/fm2/*");

    Server server = new Server(9002);
    server.setHandler(handler);
    server.start();
    server.join();
  }
}
