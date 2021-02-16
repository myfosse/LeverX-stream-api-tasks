import static worker.TaskWorker.*;

import java.util.List;

import entity.Task;

/** @author Andrei Yahorau */
public class TaskForReadStart {
  public static void main(String[] args) {

    final List<Task> tasks = generateListOfTasks();

    System.out.println(tasks);

    System.out.println(
            getAllTasksGroupByFourParametersByFunctionGrouping(tasks));

    System.out.println(
            getAllTasksGroupByFourParametersByClassGroping(tasks));

    System.out.println(
        getFirstFiveReadingTasksSortedByCreatedOnTimeToSingleStringByComma(tasks));
  }
}
