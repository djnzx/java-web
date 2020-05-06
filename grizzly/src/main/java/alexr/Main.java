package alexr;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * http://localhost:8081/myapp/root/next
 * http://localhost:8081/myapp/root/p
 * http://localhost:8081/myapp/root/next
 */

public class Main {
    public static final String BASE_URI = "http://localhost:8081/myapp/";

    public static void main(String[] args) throws IOException {
        final ResourceConfig rc = new ResourceConfig().packages("alexr");
        final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
        System.out.println(BASE_URI);
        System.in.read();
        server.shutdownNow();
    }
}

