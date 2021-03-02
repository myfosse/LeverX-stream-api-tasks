package converter;

import static java.util.stream.Collectors.toList;

import java.util.List;

import lombok.experimental.UtilityClass;

import dto.TaskDto;
import entity.Task;

/** @author Andrei Yahorau */
@UtilityClass
public class TaskConverter {

  public static List<TaskDto> convertListOfTaskToListOfTaskDto(final List<Task> tasks) {
    return tasks.stream()
            .map(TaskConverter::convertTaskToTaskDto)
            .collect(toList());
  }

  public static TaskDto convertTaskToTaskDto(final Task task) {
    return TaskDto.builder()
        .id(task.getId())
        .title(task.getTitle())
        .type(task.getType())
        .createdOn(task.getCreatedOn())
        .tags(task.getTags())
        .build();
  }
}
