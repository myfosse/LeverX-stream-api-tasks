package entity;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/** @author Andrei Yahorau */
@Data
public class Student {

  private String name;
  private Map<String, Integer> rating;

  public Student(final String name) {
    rating = new HashMap<>();
    this.name = name;
  }

  public Student rate(final String subject, final Integer rate) {
    rating.put(subject, rate);
    return this;
  }
}
