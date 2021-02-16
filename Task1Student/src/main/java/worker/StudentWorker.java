package worker;

import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

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
import java.util.stream.IntStream;
import java.util.stream.Stream;

import lombok.experimental.UtilityClass;

import entity.Student;

/** @author Andrei Yahorau */
@UtilityClass
public class StudentWorker {

  private final Random random = new Random();

  public double getAverageRatingForSubjectFromListOfStudents(
      final List<Student> students, final String subject) {
    return students.stream()
        .filter(student -> student.getRating().containsKey(subject))
        .mapToDouble(s -> s.getRating().get(subject))
        .average()
        .orElse(0);
  }

  public Set<String> getAllSubjects(final List<Student> students) {

    Set<String> subjects = new HashSet<>();
    students.stream().map(Student::getSubjects).forEach(subjects::addAll);
    return subjects;
  }

  public Map<String, Object> getAllSubjectsWithStudentsMarks(final List<Student> students) {
    return students.stream()
        .map(Student::getRating)
        .map(Map::keySet)
        .reduce(
            new HashSet<>(),
            (subjects, studentSubjects) -> {
              subjects.addAll(studentSubjects);
              return subjects;
            })
        .stream()
        .collect(
            toMap(
                identity(),
                subject ->
                    students.stream()
                        .filter(student -> student.getRating().containsKey(subject))
                        .map(student -> student.getName() + ": " + student.getRating().get(subject))
                        .collect(joining(", ", "(", ")"))));
  }

  public Map<String, List<String>> getAllSubjectsWithListOfStudentsMarks(
      final List<Student> students) {

    Map<String, List<String>> answer = new HashMap<>();
    getAllSubjects(students)
        .forEach(
            sub -> {
              List<String> temp =
                  students.stream()
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
    IntStream.range(0, AMOUNT_OF_SUBJECTS)
        .forEach(
            j ->
                student.rate(SUBJECT_RANDOM_NAME_PREFIX + j, random.nextInt(MAX_SUBJECT_MARK + 1)));
  }
}
