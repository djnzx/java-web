package org.alexr.web.freemarker;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class FreemarkerServlet02 extends HttpServlet {

  private TemplateEngine engine;

  public FreemarkerServlet02(TemplateEngine engine) {
    this.engine = engine;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String jim = "Jim";
    int num = 42;

    HashMap<String, Object> data = new HashMap<>();
    data.put("name", jim);
    data.put("count", String.valueOf(num));

    engine.render("template02.ftl", data, resp);
  }
}
