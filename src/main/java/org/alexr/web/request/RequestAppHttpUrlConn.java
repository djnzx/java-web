package org.alexr.web.request;

import org.apache.http.client.config.RequestConfig;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class RequestAppHttpUrlConn {
  public static void main(String[] args) throws IOException {
    URL url = new URL("http://www.acme.com");
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");
    con.setDoOutput(true);
    con.
    out.flush();
    out.close();
  }

}
