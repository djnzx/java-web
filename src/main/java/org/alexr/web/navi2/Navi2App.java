package org.alexr.web.navi2;

import org.alexr.web.freemarker.TemplateEngine;
import org.alexr.web.navi2.servlet.*;
import org.alexr.web.service.Auth;
import org.alexr.web.service.AuthService;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * http://localhost:9009/login
 */
public class Navi2App {
  public static void main(String[] args) throws Exception {
    Auth auth = new AuthService();

    TemplateEngine te = TemplateEngine.folder("./content_navi2/template");
    ServletContextHandler handler = new ServletContextHandler();

    // static content
    handler.addServlet((new ServletHolder(new SvtStaticContent("./content_navi2"))), "/static/*");

    // login/logout operations
    handler.addServlet((new ServletHolder(new SvtLogin(te, auth))), "/login/*");
    handler.addServlet((new ServletHolder(new SvtLogout(te))), "/logout/*");

    // menu / calc / history
    handler.addServlet((new ServletHolder(new SvtMenu(te))), "/menu/*");
    handler.addServlet((new ServletHolder(new SvtCalc(te))), "/calc/*");
    handler.addServlet((new ServletHolder(new SvtHistory(te))), "/history/*");

    // redirect for all other wrong requests
    handler.addServlet(new ServletHolder(new SvtRedirect("/login")), "/*");

    Server server = new Server(9009);
    server.setHandler(handler);
    server.start();
    server.join();
  }

}
