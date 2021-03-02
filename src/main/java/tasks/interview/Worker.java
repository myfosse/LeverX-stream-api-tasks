package tasks.interview;

import static java.util.Map.Entry.comparingByValue;
import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import static lombok.AccessLevel.PRIVATE;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import lombok.NoArgsConstructor;

/** @author Andrei Yahorau */
@NoArgsConstructor(access = PRIVATE)
public final class Worker {

  public static String findMostCommonCharacterAtStringByFor(final String input) {

    Map<Character, Integer> symbolsMap = new HashMap<>();
    IntStream.range(0, input.length())
        .forEach(
            i -> {
              char ch = input.charAt(i);
              if (symbolsMap.containsKey(ch)) {
                symbolsMap.put(ch, (symbolsMap.get(ch) + 1));
              } else {
                symbolsMap.put(ch, 1);
              }
            });
    return symbolsMap.entrySet().stream().max(comparingByValue()).toString();
  }

  public static String findMostCommonCharacterAtStringByStream(final String input) {
    return input
        .chars()
        .mapToObj(symbol -> (char) symbol)
        .collect(groupingBy(identity(), counting()))
        .entrySet()
        .stream()
        .max(comparingByValue())
        .toString();
  }
}
