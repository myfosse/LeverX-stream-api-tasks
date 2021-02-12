package worker;

import config.StudentWorkerConfig;
import entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/** @author Andrei Yahorau */
public class StudentWorker {

  public static Double getAverageRatingForSubjectFromListOfStudents(
      final List<Student> students, final String subject) {
    return students.stream()
        .mapToDouble(s -> s.getRating().getOrDefault(subject, 0))
        .average()
        .orElse(0);
  }

  // TODO: make stream!?
  public static List<Student> generateListOfStudent() {

    final Random random = new Random();

    final List<Student> students = new ArrayList<>();

    for (int i = 0; i < StudentWorkerConfig.AMOUNT_OF_STUDENTS; i++) {
      Student student = new Student(StudentWorkerConfig.STUDENT_RANDOM_NAME + 1);
      for (int j = 0; j < StudentWorkerConfig.AMOUNT_OF_SUBJECTS; j++) {
        student.rate(
            StudentWorkerConfig.SUBJECT_RANDOM_NAME + j,
            random.nextInt(StudentWorkerConfig.MAX_SUBJECT_MARK + 1));
      }
      students.add(student);
    }

    return students;
  }
}
