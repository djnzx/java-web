package org.alexr.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ServletFile extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    /**
     * http://localhost:8082/static/index.html
     * req.getPathInfo() - /index.html
     */
    String gotPathInfo = req.getPathInfo();
    Path path = Paths.get("./content", gotPathInfo);
    ServletOutputStream os = resp.getOutputStream();
    Files.copy(path, os);
  }
}
