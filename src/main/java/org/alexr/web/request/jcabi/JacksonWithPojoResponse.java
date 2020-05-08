package org.alexr.web.request.jcabi;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jcabi.aspects.Immutable;
import com.jcabi.http.Request;
import com.jcabi.http.Response;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Immutable
public final class JacksonWithPojoResponse implements Response {

  private final transient Response response;

  private static final ObjectMapper MAPPER = new ObjectMapper()
      .configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);

  public JacksonWithPojoResponse(final Response resp) {
    this.response = resp;
  }

  public <T> T toPojo(final Class<T> type) {
    try {
      return MAPPER.readValue(this.binary(), type);
    } catch (IOException e) {
      throw new IllegalArgumentException(
          "Cannot read as an object. The JSON is not a valid object."
      );
    }
  }

  @Override
  public Request back() {
    return this.response.back();
  }

  @Override
  public int status() {
    return this.response.status();
  }

  @Override
  public String reason() {
    return this.response.reason();
  }

  @Override
  public Map<String, List<String>> headers() {
    return this.response.headers();
  }

  @Override
  public String body() {
    return this.response.body();
  }

  @Override
  public byte[] binary() {
    return this.response.binary();
  }

  @Override
  public <T extends Response> T as(Class<T> type) {
    return this.response.as(type);
  }

}
