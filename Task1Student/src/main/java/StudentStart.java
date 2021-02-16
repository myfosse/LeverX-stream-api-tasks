import static worker.StudentWorker.*;

import java.util.List;

import entity.Student;

/** @author Andrei Yahorau */
public class StudentStart {
  public static void main(String[] args) {

    final List<Student> students = generateListOfStudents();
    final String subjectNameToGetAverageScore = "subject_1";

    System.out.println(students);

    System.out.println(getAllSubjectsWithStudentsMarks(students));
    System.out.println(getAllSubjectsWithListOfStudentsMarks(students));

    System.out.println(
        getAverageRatingForSubjectFromListOfStudents(students, subjectNameToGetAverageScore));
  }
}
