package worker;

import static java.util.stream.Collectors.toList;

import static constant.StudentWorkerConstant.AMOUNT_OF_STUDENTS;
import static constant.StudentWorkerConstant.AMOUNT_OF_SUBJECTS;
import static constant.StudentWorkerConstant.STUDENT_RANDOM_NAME_PREFIX;
import static constant.StudentWorkerConstant.SUBJECT_RANDOM_NAME_PREFIX;
import static constant.StudentWorkerConstant.MAX_SUBJECT_MARK;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import lombok.experimental.UtilityClass;

import entity.Student;

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

  public Set<String> getAllSubjects(final List<Student> students) {
    Set<String> subjects = new HashSet<>();
    students.stream().map(Student::getSubjects).forEach(subjects::addAll);
    return subjects;
  }

  public Map<String, List<String>> getAllSubjectsWithListOfStudentsWithMark(
      final List<Student> students) {

    Map<String, List<String>> answer = new HashMap<>();
    getAllSubjects(students).forEach(sub -> {
      List<String> temp = students.stream()
              .filter(student -> student.getSubjects().contains(sub))
              .map(student -> student.getName() + " " + student.getRating().get(sub))
              .collect(toList());
      answer.put(sub, temp);
    });

    return answer;
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
