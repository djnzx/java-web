package org.alexr.web.request;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson2.JacksonFactory;

import java.io.IOException;

/**
 * https://www.baeldung.com/google-http-client
 */
public class RequestAppGoogleHttp {

  static HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
  static JsonFactory JSON_FACTORY = new JacksonFactory();

  public static void main(String[] args) throws IOException {
    HttpRequestFactory requestFactory = new NetHttpTransport().createRequestFactory();
    HttpRequest request = requestFactory.buildGetRequest(
        new GenericUrl("https://github.com"));
    String rawResponse = request.execute().parseAsString();

    HttpRequestFactory requestFactory2 = HTTP_TRANSPORT.createRequestFactory(
        (HttpRequest rq) -> rq.setParser(new JsonObjectParser(JSON_FACTORY))
    );



  }
}
