package org.alexr.web.request.jdk;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public class HttpClient2Post {

  private final static ObjectMapper mapper = new ObjectMapper();

  private static Optional<String> makeHttpPost(String address) {
    try {
      URL url = new URL(address);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod(HttpMethod.POST);
      conn.setRequestProperty(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON);
      conn.setRequestProperty(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON);
      conn.setDoOutput(true);

      Book book = new Book(77, "JavaScript", "Mister Bin", Arrays.asList(";)", ":)", ";("));
      byte[] bytes = mapper.writeValueAsBytes(book);

      try (OutputStream os = conn.getOutputStream()) {
        os.write(bytes);
      } catch (IOException x) {
        return Optional.empty();
      }

      try (BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
        return Optional.of(br.lines().collect(Collectors.joining("\n")));
      } catch (IOException x) {
        return Optional.empty();
      }

    } catch (IOException x) {
      return Optional.empty();
    }
  }

  public static void main(String[] args) {
    String address = "http://localhost:8081/shop/books";
    makeHttpPost(address);
  }
}
