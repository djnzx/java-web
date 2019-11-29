package org.alexr.web;

import org.alexr.web.freemarker.TemplateEngine;
import org.alexr.web.service.Auth;
import org.alexr.web.service.AuthService;
import org.alexr.web.servlet.*;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class WebApplication {
  public static void main(String[] args) throws Exception {
    Server server = new Server(9001);

    ServletContextHandler handler = new ServletContextHandler();

    handler.addServlet(ExploreRequestServlet.class, "/ex/*");
    handler.addServlet(HelloServlet.class, "/*");
    handler.addServlet(ServletFile.class, "/static/*");
    Auth authService = new AuthService();
    handler.addServlet(new ServletHolder(new LoginServlet(authService)), "/login/*");

    TemplateEngine te = TemplateEngine.folder("./content/templates");
    handler.addServlet(new ServletHolder(new TemplateServlet(te)), "/te/*");

    server.setHandler(handler);
    server.start();;
    server.join();
  }
}
