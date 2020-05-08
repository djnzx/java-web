package org.alexr.web.request.jcabi;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jcabi.http.Request;
import com.jcabi.http.request.JdkRequest;
import org.alexr.web.rest.Book;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

public class HttpClient2Post {
  private static final ObjectMapper mapper = new ObjectMapper();

  public static void main(String[] args) throws IOException {
    Book book = new Book(77, "JavaScript", "Mister Bin", Arrays.asList(";)", ":)", ";("));

    new JdkRequest(new URL("http://localhost:8081/shop/books"))
        .method(Request.POST)
        .body()
        .set(mapper.writeValueAsBytes(book))
        .back()
        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON) // what is sent
        .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON) // what is expected
//        .header(HttpHeaders.SET_COOKIE, "MyCookie=315")
        .fetch();
  }
}
