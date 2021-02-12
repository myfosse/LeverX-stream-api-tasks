import static converter.TaskConverter.convertListOfTaskToListOfTaskDto;
import static worker.TaskWorker.generateListOfTasks;

import entity.Task;

import java.util.List;

/** @author Andrei Yahorau */
public class TaskForReadDtoStart {
  public static void main(String[] args) {

    final List<Task> tasks = generateListOfTasks();

    System.out.println(tasks.toString());

    System.out.println(convertListOfTaskToListOfTaskDto(tasks));
  }
}
