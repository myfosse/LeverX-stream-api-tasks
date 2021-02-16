package dto;

import java.time.LocalDate;
import java.util.Set;

import lombok.Builder;
import lombok.Data;

import entity.TaskType;

@Data
@Builder
public class TaskDto {

  private final String id;

  private final String title;

  private final TaskType type;

  private final LocalDate createdOn;

  private Set<String> tags;
}
