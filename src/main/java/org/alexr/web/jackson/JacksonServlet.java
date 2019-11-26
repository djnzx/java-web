package org.alexr.web.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.alexr.web.entity.Person;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * detailed documentation can be found here:
 *
 * https://www.baeldung.com/jackson-object-mapper-tutorial
 * https://www.baeldung.com/jackson-xml-serialization-and-deserialization
 */
public class JacksonServlet extends HttpServlet {

  private final ObjectMapper mapper;

  public JacksonServlet(ObjectMapper mapper) {
    this.mapper = mapper;
  }

  /**
   * writing value to the browser
   *
   * in order to serialize - you need to have
   * getters for all fields
   */
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    Person john = new Person(123, "John", 42);
    Person jim = new Person(234, "Jim", 55, Arrays.asList("Developer", "Leader"));
    try (PrintWriter w = resp.getWriter()) {
      w.println( mapper.writeValueAsString(john) );
      w.println(mapper.writeValueAsString(jim) );
    }
  }

  /**
   * reading value from POST request:
   *
   * in order to deserialize - you need to have
   * default constructor w/o parameters
   * and setter for all fields
   *
   * JSON test data:
   * {"id":119,"name":"Irene","age":66,"skills":["Manager","Trainer","Teacher"]}
   * XML test data:
   * <Person><id>999</id><name>Tamara</name><age>22</age><skills><skills>Master</skills><skills>Trainer</skills></skills></Person>
   */
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    // obtain a reader from the request
    BufferedReader body_reader = req.getReader();
    // read data to string. If we read only one object
    // without printing we can read directly from the `Reader` (BufferedReader)
    // we need that only for printing intermediate results
    String body = body_reader.lines().collect(Collectors.joining());
//    Person person = mapper.readValue(body_reader, Person.class);
    Person person = mapper.readValue(body, Person.class);
    System.out.println("==== text data============");
    System.out.println(body);
    System.out.println("==== deserialized to =====");
    System.out.println(person);
    System.out.println("==========================");
  }
}
