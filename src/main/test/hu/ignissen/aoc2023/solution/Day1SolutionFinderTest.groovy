package hu.ignissen.aoc2023.solution

import spock.lang.Specification

class Day1SolutionFinderTest extends Specification {

    def 'convertWordsToDigit works'() {
        given:
        def day1SolutionFinder = new Day1SolutionFinder()

        when:
        def result = day1SolutionFinder.convertWordsToDigit(line)

        then:
        expected == result

        where:
        line                                   | expected
        'onetwothree'                          | '13'
        '6sixzvdsprdqlftwonine'                | '69'
        'oneightfiveight'                      | '18'
        '5chvmhmfgl7xkjfdpdbp'                 | '57'
        'eightwothree'                         | '83'
        'abcone2threexyz'                      | '13'
        'xtwone3four'                          | '24'
        '4nineeightseven2'                     | '42'
        'zoneight234'                          | '14'
        '7pqrstsixteen'                        | '76'
        'eighthree'                            | '83'
        'eightwone'                            | '81'
        '123456789'                            | '19'
        'onetwothreefourfivesixseveneightnine' | '19'
        'oneight'                              | '18'
    }

    def 'findPart2Solution works'() {
        given:
        def day1SolutionFinder = new Day1SolutionFinder()

        when:
        def lines = [
                'two1nine',
                'eightwothree',
                'abcone2threexyz',
                'xtwone3four',
                '4nineeightseven2',
                'zoneight234',
                '7pqrstsixteen'
        ]

        then:
        281l == day1SolutionFinder.findPart2Solution(lines)

        when:
        lines = [
                'zlmlk1',
                'vqjvxtc79mvdnktdsxcqc1sevenone',
                'vsskdclbtmjmvrseven6',
                '8jkfncbeight7seven8',
                'six8dbfrsxp',
                '2zpcbjdxcjfone68six',
        ]

        then:
        340l == day1SolutionFinder.findPart2Solution(lines)

        when:
        lines = [
                'nmmpl6fc7ccg8lkvpvqplztwo', //62
                'mzbxkmfcd89six', //86
                'fbhzskjt4seven3jrvfjhqsbcone3', //43
                'five3sevensix',//56
                'eightsix6',//86
                'n9',//99
                'threeninemzpjqpcpvnine424ninesix',//36
                '8ninesfour7',//87
                'twopbsbvdpnine6fourfive7qbbckmhxgg2',//22
                '5ksvzfbdbgvnqonehsgtvgkbgjkzggsmpvkxpxtft',//51
                'qeightwo2three68nine39lr',//89
                '5gpz6283five',//55
                '19fourjctnldrqlghx',//13
                'gtwonetbqxnvxlz2three',//13
                'jdvmph5fgztldhtwoxhzk',//55
                'fourgmhflfpxmbqpt8jdxkntnchmtkgqhsgthree',//43
                '527five',//55
                '5sixfour',//54
                'mdchltjjqmfive7',//57
                'kn6glgjlspeightfivej',//65
        ]

        then:
        1135l == day1SolutionFinder.findPart2Solution(lines)
    }

    def 'findPart2Solution - single'() {
        given:
        def day1SolutionFinder = new Day1SolutionFinder()

        when: ''
        then:
        expected as Long == day1SolutionFinder.findPart2Solution([line])

        where:
        line                                        | expected
        'nmmpl6fc7ccg8lkvpvqplztwo'                 | 62
        'mzbxkmfcd89six'                            | 86
        'fbhzskjt4seven3jrvfjhqsbcone3'             | 43
        'five3sevensix'                             | 56
        'eightsix6'                                 | 86
        'n9'                                        | 99
        'threeninemzpjqpcpvnine424ninesix'          | 36
        '8ninesfour7'                               | 87
        'twopbsbvdpnine6fourfive7qbbckmhxgg2'       | 22
        '5ksvzfbdbgvnqonehsgtvgkbgjkzggsmpvkxpxtft' | 51
        'qeightwo2three68nine39lr'                  | 89
        '5gpz6283five'                              | 55
        '19fourjctnldrqlghx'                        | 14
        'gtwonetbqxnvxlz2three'                     | 23
        'jdvmph5fgztldhtwoxhzk'                     | 52
        'fourgmhflfpxmbqpt8jdxkntnchmtkgqhsgthree'  | 43
        '527five'                                   | 55
        '5sixfour'                                  | 54
        'mdchltjjqmfive7'                           | 57
        'kn6glgjlspeightfivej'                      | 65
    }
}
