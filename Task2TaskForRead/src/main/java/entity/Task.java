package entity;

import java.util.HashSet;
import java.util.Set;
import java.time.LocalDate;

import lombok.Data;

@Data
public class Task {

  private String id;

  private final String title;

  private final TaskType type;

  private final LocalDate createdOn;

  private boolean done = false;

  private Set<String> tags = new HashSet<>();

  private LocalDate dueTo;

  public Task addTag(final String tag) {
    tags.add(tag);
    return this;
  }
}
