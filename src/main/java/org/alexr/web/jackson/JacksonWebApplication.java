package org.alexr.web.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * servlet location
 * http://localhost:9010/j
 * http://localhost:9010/x
 */
public class JacksonWebApplication {
  public static void main(String[] args) throws Exception {
    ServletContextHandler handler = new ServletContextHandler();
    handler.addServlet(new ServletHolder(new JacksonServlet(new ObjectMapper())), "/j/*");
    handler.addServlet(new ServletHolder(new JacksonServlet(new XmlMapper())), "/x/*");

    Server server = new Server(9010);
    server.setHandler(handler);
    server.start();
    server.join();
  }
}
