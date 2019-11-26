package org.alexr.web.freemarker;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FreemarkerServlet04 extends HttpServlet {

  private TemplateEngine engine;

  public FreemarkerServlet04(TemplateEngine engine) {
    this.engine = engine;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    List<Integer> ints = Stream
        .generate(() -> (int)(Math.random() * 10))
        .limit(7)
        .collect(Collectors.toList());

    HashMap<String, Object> data = new HashMap<>();
    data.put("randoms", ints);

    engine.render("template04.ftl", data, resp);
  }
}
