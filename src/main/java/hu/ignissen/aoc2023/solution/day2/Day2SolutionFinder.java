package hu.ignissen.aoc2023.solution.day2;

import hu.ignissen.aoc2023.common.SolutionFinder;
import hu.ignissen.aoc2023.solution.day2.model.Game;

import java.util.List;

public class Day2SolutionFinder extends SolutionFinder {

    @Override
    protected long findSolution(final List<String> lines) {
        return lines.stream()
                .map(Game::from)
                .filter(game -> game.isPossible(12, 13, 14))
                .mapToInt(Game::getId)
                .sum();
    }

    @Override
    protected long findPart2Solution(final List<String> lines) {
        return lines.stream()
                .map(Game::from)
                .mapToInt(Game::getMinimumSetPower)
                .sum();
    }

    @Override
    protected String getFileName() {
        return "aoc-day-2.txt";
    }
}
