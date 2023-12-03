package hu.ignissen.aoc2023;

import hu.ignissen.aoc2023.solution.Day1SolutionFinder;
import hu.ignissen.aoc2023.solution.Day3SolutionFinder;
import hu.ignissen.aoc2023.solution.day2.Day2SolutionFinder;

public class Main {

    public static void main(String[] args) {
        System.out.println(new Day1SolutionFinder().findSolution());
        System.out.println(new Day1SolutionFinder().findPart2Solution());
        System.out.println();
        System.out.println(new Day2SolutionFinder().findSolution());
        System.out.println(new Day2SolutionFinder().findPart2Solution());
        System.out.println();
        System.out.println(new Day3SolutionFinder().findSolution());
        System.out.println(new Day3SolutionFinder().findPart2Solution());
    }
}
