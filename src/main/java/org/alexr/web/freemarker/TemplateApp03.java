package org.alexr.web.freemarker;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * servlet location:
 * http://localhost:9003/fm3
 */
public class TemplateApp03 {
  public static void main(String[] args) throws Exception {
    TemplateEngine engine = TemplateEngine.folder("./content/template");
    // similar way
    // but it won't compile because of private constructor
//    TemplateEngine engine2 = new TemplateEngine("./content/template");

    ServletContextHandler handler = new ServletContextHandler();
    handler.addServlet(new ServletHolder(new FreemarkerServlet03(engine)), "/fm3/*");

    Server server = new Server(9003);
    server.setHandler(handler);
    server.start();
    server.join();
  }
}
