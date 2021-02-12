package converter;

import dto.TaskDto;
import entity.Task;

import java.util.List;
import java.util.stream.Collectors;

/** @author Andrei Yahorau */
public class TaskConverter {

  public static List<TaskDto> convertListOfTaskToListOfTaskDto(final List<Task> tasks) {
    return tasks.stream().map(TaskConverter::convertTaskToTaskDto).collect(Collectors.toList());
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
