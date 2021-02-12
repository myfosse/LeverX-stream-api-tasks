package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

/** @author Andrei Yahorau */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

  private String name;
  private Map<String, Integer> rating;

  public Student(String name) {
    rating = new HashMap<>();
    this.name = name;
  }

  public Student rate(String subject, Integer rate) {
    rating.put(subject, rate);
    return this;
  }
}
