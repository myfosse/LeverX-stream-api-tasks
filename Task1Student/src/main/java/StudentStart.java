import static worker.StudentWorker.generateListOfStudents;
import static worker.StudentWorker.getAverageRatingForSubjectFromListOfStudents;

import entity.Student;

import java.util.List;

/** @author Andrei Yahorau */
public class StudentStart {
  public static void main(String[] args) {

    final List<Student> students = generateListOfStudents();
    final String subjectNameToGetAverageScore = "subject_1";

    System.out.println(students.toString());

    System.out.println(
        getAverageRatingForSubjectFromListOfStudents(students, subjectNameToGetAverageScore));
  }
}
