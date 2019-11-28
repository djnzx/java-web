package org.alexr.web.freemarker;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public final class TemplateEngine {

  private final Configuration config;

  public static TemplateEngine folder(final String path_from_project_root) throws IOException {
    return new TemplateEngine(path_from_project_root);
  }

  public static TemplateEngine resources(final String path_from_project_resources) throws IOException, URISyntaxException {
    String path = Paths
        .get(TemplateEngine.class.getResource(path_from_project_resources).toURI())
        .toFile().getAbsolutePath();
    return new TemplateEngine(path);
  }

  public TemplateEngine(final String path) throws IOException {
    this.config = new Configuration(Configuration.VERSION_2_3_28) {{
      setDirectoryForTemplateLoading(new File(path));
      setDefaultEncoding(String.valueOf(StandardCharsets.UTF_8));
      setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
      setLogTemplateExceptions(false);
      setWrapUncheckedExceptions(true);
    }};
  }

  public void render(final String templateFile, final HttpServletResponse resp) throws IOException {
    render(templateFile, new HashMap<>(), resp);
  }

  public void render(final String templateFile, final Map<String, Object> data, final HttpServletResponse resp) throws IOException {
    try {
      resp.setCharacterEncoding(String.valueOf(StandardCharsets.UTF_8));
      config.getTemplate(templateFile).process(data, resp.getWriter());
    } catch (TemplateException ex) {
      throw new IllegalArgumentException("Freemarker render error", ex);
    }
  }
}
