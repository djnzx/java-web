package org.alexr.web.entity;

import java.util.ArrayList;
import java.util.List;

public class Person {
  private int id;
  private String name;
  private int age;
  private List<String> skills;

  public Person() { }

  public Person(int id, String name, int age) {
    this(id, name, age, new ArrayList<>(0));
  }

  public Person(int id, String name, int age, List<String> skills) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.skills = skills;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public int getId() {
    return id;
  }

  public List<String> getSkills() {
    return skills;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setSkills(List<String> skills) {
    this.skills = skills;
  }

  @Override
  public String toString() {
    return String.format("Person{id=%d, name='%s', age=%d, skills=%s}", id, name, age, skills);
  }
}
