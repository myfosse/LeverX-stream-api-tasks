import static worker.TaskWorker.*;

import entity.Task;

import java.util.List;

/** @author Andrei Yahorau */
public class TaskForReadStart {
  public static void main(String[] args) {

    final List<Task> tasks = generateListOfTasks();

    System.out.println(tasks.toString());

    System.out.println(
            getAllTasksGroupByFourParameters(tasks));

    System.out.println(
        getFirstFiveReadingTasksSortedByCreatedOnTimeToSingleStringByComma(tasks));
  }
}
