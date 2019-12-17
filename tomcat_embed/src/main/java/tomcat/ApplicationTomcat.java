package tomcat;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

/**
 * http://localhost:8080/hello
 */

public class ApplicationTomcat {
  public static void main(String[] args) throws LifecycleException {
    String webappDirLocation = "src/main/webapp/";
    Tomcat tomcat = new Tomcat();

    tomcat.setPort(8080);

    // configuring app with basedir:
    StandardContext ctx = (StandardContext) tomcat.addWebapp("/", new File(webappDirLocation).getAbsolutePath());

    // Declare an alternative location for your "WEB-INF/classes" dir
    File additionWebInfClasses = new File("target/classes");
    WebResourceRoot resources = new StandardRoot(ctx);
    resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes", additionWebInfClasses.getAbsolutePath(), "/"));
    ctx.setResources(resources);

    tomcat.start();
    tomcat.getServer().await();
  }
}
