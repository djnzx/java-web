package org.alexr.web.rest.resources;

import org.alexr.web.rest.Book;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.HashMap;

@Path("books")
public class Books {

  private static final HashMap<Integer, Book> books = new HashMap<Integer, Book>() {{
    put(1, new Book(1, "Java", "Jim", Arrays.asList("a", "b")));
    put(2, new Book(2, "Scala", "John", Arrays.asList("c")));
    put(3, new Book(3, "Haskell", "Jeremy", Arrays.asList("d", "e", "f")));
  }};

  /**
   * http://localhost:8081/shop/books
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response books_all() {
    return Response
        .status(200)
        .entity(books.values())
        .build();
  }

  /**
   * http://localhost:8081/shop/books/1
   * http://localhost:8081/shop/books/2
   * http://localhost:8081/shop/books/3
   * http://localhost:8081/shop/books/4
   */
  @GET
  @Path("/{id}")
//  @Path("/{id}/{name}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response book_one(@PathParam("id") int book_id
//      , @PathParam("name") String name
//      , @CookieParam("user") Cookie cookie
  ) {
    return (!books.containsKey(book_id) ?
        Response.status(404) :
        Response.status(200).entity(books.get(book_id))
    ).build();
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response book_post(Book book) {
    System.out.printf("I've got the book: %s\n", book);
    return Response.status(201).build();
  }

}
