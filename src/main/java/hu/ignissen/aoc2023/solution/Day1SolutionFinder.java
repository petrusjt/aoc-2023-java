package hu.ignissen.aoc2023.solution;

import hu.ignissen.aoc2023.common.SolutionFinder;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Day1SolutionFinder extends SolutionFinder {

    private static final String NUMBER_PATTERN = "%s%s";
    private static final int WINDOW_SIZE = 5;
    private static final Map<String, String> WORD_TO_DIGIT_MAPPING = Map.ofEntries(
            Pair.of("one", "1"),
            Pair.of("two", "2"),
            Pair.of("three", "3"),
            Pair.of("four", "4"),
            Pair.of("five", "5"),
            Pair.of("six", "6"),
            Pair.of("seven", "7"),
            Pair.of("eight", "8"),
            Pair.of("nine", "9")
    );

    @Override
    protected long findSolution(final List<String> lines) {
        return lines.stream()
                .map(line -> Arrays.stream(line.split(""))
                        .filter(StringUtils::isNumeric).toList())
                .map(digits -> String.format(NUMBER_PATTERN, digits.get(0), digits.get(digits.size() - 1)))
                .mapToInt(Integer::valueOf)
                .sum();
    }

    @Override
    protected long findPart2Solution(final List<String> lines) {
        return lines.stream()
                .map(Day1SolutionFinder::convertWordsToDigit)
                .map(line -> Arrays.stream(line.split(""))
                        .filter(StringUtils::isNumeric).toList())
                .map(digits -> String.format(NUMBER_PATTERN, digits.get(0), digits.get(digits.size() - 1)))
                .mapToInt(Integer::valueOf)
                .sum();
    }

    private static String convertWordsToDigit(final String line) {
        var result = "";
        final var keySet = WORD_TO_DIGIT_MAPPING.keySet();
        outer: for (var i = 0; i < line.length(); i++) {
            if (StringUtils.isNumeric(String.valueOf(line.charAt(i)))) {
                result += line.charAt(i);
                break;
            } else {
                final var substring = line.substring(i, Math.min(i + WINDOW_SIZE, line.length()));
                for (final var word : keySet) {
                    if (StringUtils.containsIgnoreCase(substring, word)) {
                        result += WORD_TO_DIGIT_MAPPING.get(word);
                        break outer;
                    }
                }
            }
        }

        outer2: for (var i = line.length() - 1; i >= 0; i--) {
            if (StringUtils.isNumeric(String.valueOf(line.charAt(i)))) {
                result += line.charAt(i);
                break;
            } else {
                final var substring = line.substring(i, Math.min(i + WINDOW_SIZE, line.length()));
                for (final var word : keySet) {
                    if (StringUtils.containsIgnoreCase(substring, word)) {
                        result += WORD_TO_DIGIT_MAPPING.get(word);
                        break outer2;
                    }
                }
            }
        }
        return result;
    }

    @Override
    protected String getFileName() {
        return "aoc-day-1.txt";
    }
}
