package org.alexr.web.request.jcabi;

import com.jcabi.http.Request;
import com.jcabi.http.request.JdkRequest;
import org.alexr.web.rest.Book;

import java.io.IOException;
import java.net.URL;

public class HttpClient2Get {
  public static void main(String[] args) throws IOException {
    Book book = new JdkRequest(new URL("http://localhost:8081/shop/books/1"))
        .method(Request.GET)
        .fetch()
        .as(JacksonWithPojoResponse.class)
        .toPojo(Book.class);
    System.out.println(book);
  }
}
