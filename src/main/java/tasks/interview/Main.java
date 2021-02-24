package tasks.interview;

import static tasks.interview.Worker.findMostCommonCharacterAtStringByFor;
import static tasks.interview.Worker.findMostCommonCharacterAtStringByStream;

/** @author Andrei Yahorau */
public class Main {
  public static void main(String[] args) {
    String str = "qweqweq!!";

    System.out.println(findMostCommonCharacterAtStringByFor(str));
    System.out.println(findMostCommonCharacterAtStringByStream(str));
  }
}
