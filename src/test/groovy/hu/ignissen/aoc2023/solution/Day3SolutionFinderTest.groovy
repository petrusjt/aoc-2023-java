package hu.ignissen.aoc2023.solution

import spock.lang.Specification

class Day3SolutionFinderTest extends Specification {

    def 'findSolution works'() {
        given:
        def solutionFinder = new Day3SolutionFinder()
        def input = ['1*2']

        when:
        def result = solutionFinder.findSolution(input)

        then:
        result == 3
    }
}
