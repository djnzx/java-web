package org.alexr.web.upload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UploadServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try (OutputStream os = resp.getOutputStream()) {
      Files.copy(Paths.get("content_upload", "upload.html"), os);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    /**
     * req.getInputStream() - whole request
     * InputStream can't be reused !!!
     *
     * Collection<Part> parts = req.getParts();
     * you can access to the parts
     */
    for (Part part: req.getParts()) {
      String fname = part.getSubmittedFileName();
      try (InputStream is = part.getInputStream()) {
        Files.copy(is, Paths.get("_uploaded", fname));
      }
    }

    try (PrintWriter w = resp.getWriter()) {
      w.write("POST got");
    }
  }
}
