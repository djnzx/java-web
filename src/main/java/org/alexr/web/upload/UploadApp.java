package org.alexr.web.upload;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

import javax.servlet.MultipartConfigElement;

public class UploadApp {
  public static void main(String[] args) throws Exception {
    Server server = new Server(8080);
    ServletContextHandler handler = new ServletContextHandler();

    long maxFileSize = 1024 * 1024 * 50; // 50 Mb
    long maxRequestSize = -1L;           // No Limits
    int fileSizeThreshold = 1024 * 1024;

    handler.addServlet(UploadServlet.class, "/upload/*")
        .getRegistration().setMultipartConfig(new MultipartConfigElement(
        "./tmp"
//        , maxFileSize, maxRequestSize, fileSizeThreshold
        )
    );

    server.setHandler(handler);
    server.start();
    server.join();
  }
}
