package org.alexr.web.request;

import org.apache.http.client.config.RequestConfig;

public class RequestAppApache {
  public static void main(String[] args) {
    RequestConfig config = RequestConfig.custom()
        .setConnectTimeout(100)
        .setConnectionRequestTimeout(100)
        .setSocketTimeout(300)
        .build();
  }

}
