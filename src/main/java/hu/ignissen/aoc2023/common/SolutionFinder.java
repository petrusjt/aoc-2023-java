package hu.ignissen.aoc2023.common;

import hu.ignissen.aoc2023.common.exception.FileNotFoundException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public abstract class SolutionFinder {

    public long findSolution() {
        final var lines = readFile();
        return findSolution(lines);
    }

    protected abstract long findSolution(List<String> lines);

    public long findPart2Solution() {
        final var lines = readFile();
        return findPart2Solution(lines);
    }

    protected long findPart2Solution(final List<String> lines) {
        return 0;
    }

    private List<String> readFile() {
        try {
            return Files.readAllLines(Path.of(getFileName()));
        } catch (IOException e) {
            throw new FileNotFoundException(getFileName() + " not found!");
        }
    }

    protected abstract String getFileName();
}
