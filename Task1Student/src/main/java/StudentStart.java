import entity.Student;
import worker.StudentWorker;

import java.util.*;

/** @author Andrei Yahorau */
public class StudentStart {
  public static void main(String[] args) {

    final List<Student> students = StudentWorker.generateListOfStudent();
    final String subjectNameToGetAverageScore = "subject_1";

    System.out.println(students.toString());

    System.out.println(
        StudentWorker.getAverageRatingForSubjectFromListOfStudents(
            students, subjectNameToGetAverageScore));
  }
}
