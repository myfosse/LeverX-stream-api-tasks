package converter;

import dto.TaskDto;
import entity.Task;

import static java.util.stream.Collectors.toList;

import lombok.experimental.UtilityClass;

import java.util.List;

/** @author Andrei Yahorau */
@UtilityClass
public class TaskConverter {

  public static List<TaskDto> convertListOfTaskToListOfTaskDto(final List<Task> tasks) {
    return tasks.stream().map(TaskConverter::convertTaskToTaskDto).collect(toList());
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
