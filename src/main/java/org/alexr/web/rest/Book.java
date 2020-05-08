package org.alexr.web.rest;

import java.util.List;

public class Book {
  private int id;
  private String name;
  private String author;
  private List<String> topics;

  public Book(int id, String name, String author, List<String> topics) {
    this.id = id;
    this.name = name;
    this.author = author;
    this.topics = topics;
  }

  public Book() { }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public List<String> getTopics() {
    return topics;
  }

  public void setTopics(List<String> topics) {
    this.topics = topics;
  }

  @Override
  public String toString() {
    return String.format("Book:[id=%d, name='%s', author='%s', topics=%s]", id, name, author, topics);
  }
}
