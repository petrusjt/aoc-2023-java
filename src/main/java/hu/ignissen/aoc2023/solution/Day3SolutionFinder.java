package hu.ignissen.aoc2023.solution;

import hu.ignissen.aoc2023.common.SolutionFinder;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class Day3SolutionFinder extends SolutionFinder {
    @Override
    protected long findSolution(final List<String> lines) {
        final List<String> partNumbers = new ArrayList<>();
        for (var lineIndex = 0; lineIndex < lines.size(); lineIndex++) {
            final var line = lines.get(lineIndex);
            for (var columnIndex = 0; columnIndex < line.length(); columnIndex++) {
                if (StringUtils.isNumeric(String.valueOf(line.charAt(columnIndex)))) {
                    var numberLength = 1;
                    while (columnIndex + numberLength < line.length() && StringUtils.isNumeric(
                            String.valueOf(line.charAt(columnIndex + numberLength)))) {
                        numberLength++;
                    }
                    final var partNumber = line.substring(columnIndex, columnIndex + numberLength);
                    if (isAnyNeighbourSymbol(lines, lineIndex, columnIndex, numberLength)) {
                        partNumbers.add(partNumber);
                    }
                    columnIndex += numberLength - 1;
                }
            }
        }
        return partNumbers.stream()
                .mapToInt(Integer::parseInt)
                .sum();
    }

    private boolean isAnyNeighbourSymbol(final List<String> lines, final int lineIndex,
            final int columnIndex, final int numberLength) {
        if (lineIndex > 0) {
            final var line = lines.get(lineIndex - 1);
            for (var i = Math.max(columnIndex - 1, 0);
                 i < Math.min(columnIndex + numberLength + 1, line.length() - 1); i++) {
                final var character = line.charAt(i);
                if (isSymbol(character)) {
                    return true;
                }
            }
        }

        // INTENTIONAL nested block so 'line' doesn't conflict with later 'if'
        {
            final var line = lines.get(lineIndex);
            final var characterBeforeNumber = line.charAt(Math.max(columnIndex - 1, 0));
            final var characterAfterNumber = line.charAt(Math.min(columnIndex + numberLength, line.length() - 1));
            if (isSymbol(characterBeforeNumber) || isSymbol(characterAfterNumber)) {
                return true;
            }
        }

        if (lineIndex < lines.size() - 1) {
            final var line = lines.get(lineIndex + 1);
            for (var i = Math.max(columnIndex - 1, 0);
                 i < Math.min(columnIndex + numberLength + 1, line.length() - 1); i++) {
                final var character = line.charAt(i);
                if (isSymbol(character)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isSymbol(final char character) {
        return !CharUtils.isAsciiNumeric(character) && character != '.';
    }

    @Override
    protected long findPart2Solution(final List<String> lines) {
        final List<Integer> gearRatios = new ArrayList<>();
        for (var lineIndex = 0; lineIndex < lines.size(); lineIndex++) {
            final var line = lines.get(lineIndex);
            for (var columnIndex = 0; columnIndex < line.length(); columnIndex++) {
                if (line.charAt(columnIndex) == '*') {
                    final List<Integer> neighbouringNumbers = getNeighbouringNumbers(lines, lineIndex, columnIndex);
                    if (neighbouringNumbers.size() == 2) {
                        gearRatios.add(neighbouringNumbers.get(0) * neighbouringNumbers.get(1));
                    }
                }
            }
        }
        return gearRatios.stream()
                .reduce(Integer::sum).orElseThrow();
    }

    private List<Integer> getNeighbouringNumbers(final List<String> lines, final int lineIndex, final int columnIndex) {
        final List<Integer> neighbouringNumbers = new ArrayList<>();
        getNeighbouringNumbersIfPossible(lines, lineIndex - 1, columnIndex - 1).ifPresent(neighbouringNumbers::add);
        getNeighbouringNumbersIfPossible(lines, lineIndex - 1, columnIndex).ifPresent(neighbouringNumbers::add);
        getNeighbouringNumbersIfPossible(lines, lineIndex - 1, columnIndex + 1).ifPresent(neighbouringNumbers::add);

        getNeighbouringNumbersIfPossible(lines, lineIndex, columnIndex - 1).ifPresent(neighbouringNumbers::add);
        // this line would be checking at the star's coordinate (lines, lineIndex, columnIndex)
        getNeighbouringNumbersIfPossible(lines, lineIndex, columnIndex + 1).ifPresent(neighbouringNumbers::add);

        getNeighbouringNumbersIfPossible(lines, lineIndex + 1, columnIndex - 1).ifPresent(neighbouringNumbers::add);
        getNeighbouringNumbersIfPossible(lines, lineIndex + 1, columnIndex).ifPresent(neighbouringNumbers::add);
        getNeighbouringNumbersIfPossible(lines, lineIndex + 1, columnIndex + 1).ifPresent(neighbouringNumbers::add);

        return neighbouringNumbers.stream().distinct().toList();
    }

    private OptionalInt getNeighbouringNumbersIfPossible(final List<String> lines, final int lineIndex,
            final int columnIndex) {
        if (lineIndex < 0 || lineIndex >= lines.size()
                || columnIndex < 0 || columnIndex > lines.get(lineIndex).length()) {
            return OptionalInt.empty();
        }
        final var line = lines.get(lineIndex);
        if (CharUtils.isAsciiNumeric(line.charAt(columnIndex))) {
            // find the beginning of the number
            var innerColumnIndex = columnIndex - 1;
            while (innerColumnIndex >= 0 && CharUtils.isAsciiNumeric(line.charAt(innerColumnIndex))) {
                innerColumnIndex--;
            }
            // +1, because loop stops if line.charAt(innerColumnIndex) is NOT numeric
            innerColumnIndex++;
            StringBuilder number = new StringBuilder();
            // "parse" number
            while (innerColumnIndex < line.length() && CharUtils.isAsciiNumeric(line.charAt(innerColumnIndex))) {
                number.append(line.charAt(innerColumnIndex));
                innerColumnIndex++;
            }
            return OptionalInt.of(Integer.parseInt(number.toString()));
        }
        return OptionalInt.empty();
    }

    @Override
    protected String getFileName() {
        return "aoc-day-3.txt";
    }
}
