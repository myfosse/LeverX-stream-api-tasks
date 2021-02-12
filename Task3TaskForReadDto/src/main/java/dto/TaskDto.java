package dto;

import entity.TaskType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
public class TaskDto {
  private final String id;
  private final String title;
  private final TaskType type;
  private final LocalDate createdOn;
  private Set<String> tags = new HashSet<>();
}
