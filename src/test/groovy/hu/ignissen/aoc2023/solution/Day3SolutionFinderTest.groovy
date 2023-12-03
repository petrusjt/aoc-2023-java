package hu.ignissen.aoc2023.solution

import spock.lang.Specification

class Day3SolutionFinderTest extends Specification {

    def 'findSolution works'() {
        given:
        def solutionFinder = Spy(Day3SolutionFinder) {
            getFileName() >> 'aoc-day-3-test.txt'
        }

        when:
        def result = solutionFinder.findSolution()

        then:
        result == 4361
    }

    def 'findPart2Solution works'() {
        given:
        def solutionFinder = Spy(Day3SolutionFinder) {
            getFileName() >> 'aoc-day-3-test.txt'
        }

        when:
        def result = solutionFinder.findPart2Solution()

        then:
        result == 467835
    }
}
