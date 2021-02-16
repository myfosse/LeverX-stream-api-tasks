package entity;

import static lombok.AccessLevel.PRIVATE;

import java.time.LocalDate;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;

/** @author Andrei Yahorau */
@Data
@AllArgsConstructor(access = PRIVATE)
public class TaskGrouping {

  private final TaskType type;

  private final LocalDate createdOn;

  private final String title;

  private Set<String> tags;

  public static TaskGrouping of(Task task) {
    return new TaskGrouping(task.getType(), task.getCreatedOn(), task.getTitle(), task.getTags());
  }
}
