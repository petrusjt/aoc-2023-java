package hu.ignissen.aoc2023.solution;

import hu.ignissen.aoc2023.common.SolutionFinder;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

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
    protected String getFileName() {
        return "aoc-day-3.txt";
    }
}
