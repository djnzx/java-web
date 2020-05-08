package org.alexr.web.rest;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class JerseyServerApp {
  public static void main(String[] args) {
    ResourceConfig config = new ResourceConfig()
        .packages("org.alexr.web.rest.resources");
    HttpServer server = GrizzlyHttpServerFactory.createHttpServer(
        URI.create("http://localhost:8081/shop"),
        config
    );
//    server.shutdownNow();
  }
}
