package alexr;

import javax.ws.rs.*;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/root")
public class MyResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String m0() {
        return "This is the root of the service";
    }

    @Path("/p")
    @GET
//    @Produces(MediaType.TEXT_PLAIN)
    public Person m11(@CookieParam("dscsdc")Cookie c) {
        return new Person(1,"Demon");
    }

    @Path("/next")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String m1() {
        return "this is the next level";
    }

    @GET
    @Path("/next/{param}")
    public Response m3(@PathParam("param") String msg) {
        return Response.status(200).entity(
                String.format("Hello, %s", msg)
        ).build();
    }
}
