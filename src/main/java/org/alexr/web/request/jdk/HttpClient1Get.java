package org.alexr.web.request.jdk;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.HttpMethod;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Optional;
import java.util.stream.Collectors;

public class HttpClient1Get {

  private final static ObjectMapper mapper = new ObjectMapper();

  private static Optional<String> makeHttpGet(String address) {
    try {
      URL url = new URL(address);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod(HttpMethod.GET);
      try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
        return Optional.of(br.lines().collect(Collectors.joining("\n")));
      } catch (IOException x) {
        return Optional.empty();
      }
    } catch (IOException x) {
      return Optional.empty();
    }
  }

  private static Optional<Book> jsonToBook(String json) {
    try {
      return Optional.of(mapper.readValue(json, Book.class));
    } catch (JsonProcessingException e) {
      return Optional.empty();
    }
  }

  public static void main(String[] args) {
    String address = "http://localhost:8081/shop/books/1";
    Optional<String> response = makeHttpGet(address);
    System.out.println(response);
    Optional<Book> book = response.flatMap(HttpClient1Get::jsonToBook);
    System.out.println(book);
  }
}
