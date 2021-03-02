package entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import lombok.Data;

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

  public Set<String> getSubjects() {
    return rating.keySet();
  }
}
