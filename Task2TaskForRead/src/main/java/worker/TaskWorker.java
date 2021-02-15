package worker;

import entity.Task;

import static entity.TaskType.READING;
import static entity.TaskType.CODING;
import static entity.TaskType.WRITING;
import static java.util.Arrays.asList;

import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/** @author Andrei Yahorau */
@UtilityClass
public class TaskWorker {

  public String getFirstFiveReadingTasksSortedByCreatedOnTimeToSingleStringByComma(
      final List<Task> tasks) {
    return tasks.stream()
        .filter(t -> t.getType().equals(READING))
        .limit(5)
        .sorted(Comparator.comparing(Task::getCreatedOn))
        .map(Task::getTitle)
        .collect(Collectors.joining(", "));
  }

  public List<Task> generateListOfTasks() {

    Task task1 =
        new Task(
                "Read Version Control with Git book",
                READING,
                LocalDate.of(2015, Month.JULY, 1))
            .addTag("git")
            .addTag("reading")
            .addTag("books");

    Task task2 =
        new Task("Read Java 8 Lambdas book", READING, LocalDate.of(2015, Month.JULY, 2))
            .addTag("java8")
            .addTag("reading")
            .addTag("books");

    Task task3 =
        new Task(
                "Write a mobile application to store my tasks",
                CODING,
                LocalDate.of(2015, Month.JULY, 3))
            .addTag("coding")
            .addTag("mobile");

    Task task4 =
        new Task(
                "Write a blog on Java 8 Streams",
                WRITING,
                LocalDate.of(2015, Month.JULY, 4))
            .addTag("blogging")
            .addTag("writing")
            .addTag("streams");

    Task task5 =
        new Task(
                "Read Domain Driven Design book",
                READING,
                LocalDate.of(2015, Month.JULY, 5))
            .addTag("ddd")
            .addTag("books")
            .addTag("reading");

    return asList(task1, task2, task3, task4, task5);
  }
}
