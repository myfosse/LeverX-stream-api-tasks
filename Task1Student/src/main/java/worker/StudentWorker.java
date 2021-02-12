package worker;

import entity.Student;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static config.StudentWorkerConfig.AMOUNT_OF_STUDENTS;
import static config.StudentWorkerConfig.AMOUNT_OF_SUBJECTS;
import static config.StudentWorkerConfig.STUDENT_RANDOM_NAME_PREFIX;
import static config.StudentWorkerConfig.SUBJECT_RANDOM_NAME_PREFIX;
import static config.StudentWorkerConfig.MAX_SUBJECT_MARK;
import static java.util.stream.Collectors.toList;

/** @author Andrei Yahorau */
@UtilityClass
public class StudentWorker {

  private final Random random = new Random();

  public Double getAverageRatingForSubjectFromListOfStudents(
      final List<Student> students, final String subject) {
    return students.stream()
        .mapToDouble(s -> s.getRating().getOrDefault(subject, 0))
        .average()
        .orElse(0);
  }

  public List<Student> generateListOfStudents() {

    final AtomicInteger ordinal = new AtomicInteger(0);
    return Stream.generate(
            () -> new Student(STUDENT_RANDOM_NAME_PREFIX + ordinal.getAndIncrement()))
        .limit(AMOUNT_OF_STUDENTS)
        .peek(StudentWorker::generateStudentRating)
        .collect(toList());
  }

  private void generateStudentRating(final Student student) {
    for (int j = 0; j < AMOUNT_OF_SUBJECTS; j++) {
      student.rate(SUBJECT_RANDOM_NAME_PREFIX + j, random.nextInt(MAX_SUBJECT_MARK + 1));
    }
  }
}
