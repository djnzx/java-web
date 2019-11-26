package org.alexr.web.freemarker;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public class FreemarkerServlet03 extends HttpServlet {

  private TemplateEngine engine;

  public FreemarkerServlet03(TemplateEngine engine) {
    this.engine = engine;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    Dog jack = new Dog(33, "Jack");

    HashMap<String, Object> data = new HashMap<>();
    data.put("dog", jack);

    engine.render("template03.ftl", data, resp);
  }
}
