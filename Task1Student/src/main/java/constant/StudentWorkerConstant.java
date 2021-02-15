package constant;

import static lombok.AccessLevel.PRIVATE;


import lombok.NoArgsConstructor;

/** @author Andrei Yahorau */
@NoArgsConstructor(access = PRIVATE)
public class StudentWorkerConstant {
  public static final int AMOUNT_OF_STUDENTS = 10;
  public static final int AMOUNT_OF_SUBJECTS = 10;
  public static final int MAX_SUBJECT_MARK = 10;
  public static final String STUDENT_RANDOM_NAME_PREFIX = "name_";
  public static final String SUBJECT_RANDOM_NAME_PREFIX = "subject_";
}
