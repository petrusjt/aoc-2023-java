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
        line                                                  | expected
        'zlmlk1'                                              | 11
        'vqjvxtc79mvdnktdsxcqc1sevenone'                      | 71
        'vsskdclbtmjmvrseven6'                                | 76
        '8jkfncbeight7seven8'                                 | 88
        'six8dbfrsxp'                                         | 68
        '2zpcbjdxcjfone68six'                                 | 26
        'zqmzgfivethreefdnlhpeight8798'                       | 58
        'fivenineone6'                                        | 56
        '6sixzvdsprdqlftwonine'                               | 69
        'lqztrmztwo8dg'                                       | 28
        'four6onerv2pfhm'                                     | 42
        'plvzrs5'                                             | 55
        '5282gdnc918'                                         | 58
        'pskjsrchjpxoneonenine96fivefour'                     | 14
        'fivefour2hhtprpjndm4'                                | 54
        '6qbdcfdjsd1lmldklflteight'                           | 68
        'gctgdhpkkjninekj65rkqg8'                             | 98
        'eight6gcjlsmzt5'                                     | 85
        '5chvmhmfgl7xkjfdpdbp'                                | 57
        '5tpzpnrgpftrnine'                                    | 59
        'threeonehqbzktq1'                                    | 31
        '685fivetwofour4lvgxgdb'                              | 64
        '9jdxljkfqttstqxdzdsztsxrfjbkqmmsqzseven'             | 97
        'twostcllbpndtwo15seven'                              | 27
        '8fivetwofivetjfvsxzs5kdkpxgxvsfhr7'                  | 87
        'sevenlvrc2fivefivesixqkzdkrfour'                     | 74
        '45jjpmnscmmk'                                        | 45
        'lhxgbfjtcknpvz6'                                     | 66
        'tndgnkcqtjbrzgbrfjr3fiveqxlktntzthree'               | 33
        'vqb6threeeightbdt'                                   | 68
        '1eighteight7fourone8'                                | 18
        'bcmqn9onecnrzhsrsgzggzhtskjeightbz6khfhccktwonenrj'  | 91
        '6qmgkbkmlxfourprhxrxrdseight'                        | 68
        '9three479'                                           | 99
        '9two6zhtjzfmjrteight'                                | 98
        '1fiverrxdmvfvxhs7jqzzqpcflzt75'                      | 15
        'pnjmlpbbeightskgdf6one'                              | 81
        '6cpzqzfsjtpfq135'                                    | 65
        '484'                                                 | 44
        'llfvhxglfivesixthreenseven36'                        | 56
        'jhcpt9rq7fhzbnhk'                                    | 97
        'tthree5lrgtbxxvonezfmdpseven2'                       | 32
        '67jmrxfdmfbmzsixkzghng'                              | 66
        'sixthreefdbzhslqone2sevenfoursevennlnpjgsx'          | 67
        '54zrkfbfq'                                           | 54
        'six7rfpfbzbghxcnxlnfjkznine7'                        | 67
        '8dfoursm338cz'                                       | 88
        'sevenfiveeightone68'                                 | 78
        'dqmvcbdclx23653'                                     | 23
        'eight58qgjlcvflrggndskff'                            | 88
        'shmmk28'                                             | 28
        '93eightdtgcnhphv1'                                   | 91
        'gdtdjgggtj3dgrqsmvfh'                                | 33
        'one3pksbh32three'                                    | 13
        '9kkpjrmhmmlzvqngnhftwoonexjqmnfive'                  | 95
        'rlsevenblrvrk7'                                      | 77
        'nine9hqmtshkjdhs'                                    | 99
        '93fdbrbnnvxsktggqnjfjk7brsncmxkcfzhm34'              | 94
        '248twofbkfpxtheightwovng'                            | 22
        '28746threecbffiveseven'                              | 27
        'eight449'                                            | 89
        '4eightnine4ptmzvpfqxhrzvrpjhfsdsvlhbht'              | 44
        'sevensevenfive6bjf'                                  | 76
        'sqthreevhmvbgxvnk2one'                               | 31
        'ghpsix5seven31'                                      | 61
        '7llnsgdtzbxjbbqcmxfhgcdnptwothreeone'                | 71
        'eight3fouroneplsrfvqf'                               | 81
        '4six6one'                                            | 41
        '27twofvlssjbsk8j'                                    | 28
        'njlllqnrvx8four'                                     | 84
        '5onekcngbbmpnxseven9fourzcprjp'                      | 54
        'sevenfive2sevenknzpxtx'                              | 77
        '8eightljhtmnxpjhxhnqtwo1rjddcbj'                     | 81
        'mzsqh3sixfivethree'                                  | 33
        'deightwoeighteight5'                                 | 85
        'nine42sevenscnjeight97'                              | 97
        '2gcrkrfourfivenpzssevenseven4'                       | 24
        'eightdtwosevenmj3two'                                | 82
        '9zkhqlcd3'                                           | 93
        'ctpncdkcmonehfive9'                                  | 19
        'sixrtwo7rqnine689'                                   | 69
        'sevenm16gshq4xqdxqbhcl'                              | 74
        'zxxnrpstkkmnhcc6'                                    | 66
        'three1sixninelsxrbkpneight'                          | 38
        'jzkfvrtmctjz5'                                       | 55
        'sdsfrh4nine'                                         | 49
        'foureightfive7six'                                   | 46
        'ninesixfivefive53seven'                              | 97
        '42threezpvxnrg5sfzctbtk'                             | 45
        'seven7pkfnqggvjthreextfksczdd'                       | 73
        'xsb6ntlfzxvlxrkx1sevenkmnqxhcdnqkdzt'                | 67
        '6sbzfqfdm'                                           | 66
        'lrfjxppqbdseven94ntnskpkdqeightsix5xskh'             | 75
        '98czzcq'                                             | 98
        '696cmcdpztwojk6tz'                                   | 66
        'jbpfbqfdd64four2onezrfm'                             | 61
        '9jfklkpcffive5phpzqvhrtcqvmxvmgljn8'                 | 98
        '329sixjglqzqzjnlsqbnqnzsb56'                         | 36
        '59three'                                             | 53
        '4863five'                                            | 45
        '6txkcgtn7gtsxgtnine'                                 | 69
        'lxdtnjvjbgxpnrft8eight2cjqfdtrk6dm'                  | 86
        'twothree53'                                          | 23
        'two1qf4'                                             | 24
        '6ltxhxcdfive'                                        | 65
        'rlrdkzgnk6mnsbxfkhh'                                 | 66
        '41z4nzcqzjqrnmsixtrrbgtwo'                           | 42
        'tbnsixsixtwomptdjtzkxfhlflpcdnbmrbctjscxq6qtmjmkpfk' | 66
        '1vqlkjtmjeightcjzxnzscczqmxcpvnprhtwo'               | 12
        'lznhcphkdmrhpninesix344'                             | 94
        'fggprsvtgmbbtlk14xkrnbcjrdbrsbdltfztmtwo'            | 12
        '6rqlzs34cdlzmxone'                                   | 61
        'two7zpbgsxl'                                         | 27
        'lckblpljvv5two75fivegttgmvcpmlhltxz'                 | 55
        'bjfbxdpvnj581three'                                  | 53
        '1seven4'                                             | 14
        '8ninezhzrgg6crlpggmtfour41lhjcqtblh'                 | 81
        'seveneight8sevenoneshvkcdhgfmxhn7dzccsdfkcx'         | 77
        '7zljpgl2'                                            | 72
        'six1two'                                             | 62
        'fourztcnpn8bsbzfhdhgkjjsthree'                       | 43
        'onepthfrh9vcs9sevenhljhmprhlsjrr'                    | 17
        'vlnpmqlpjfour5'                                      | 45
        'two3qfourlqsninethreefour'                           | 24
        'hshdseven7'                                          | 77
        'eightfive4five6four4flrzhrxzlreight'                 | 88
        'five187'                                             | 57
        'seven2xlbqkhtflqtsfhrf1vvnbt'                        | 71
        'onefiveninethree26'                                  | 16
        '2sck1n9eight6'                                       | 26
        '6sixsix7two9xznczchmx'                               | 69
        '27eight'                                             | 28
        '7six3'                                               | 73
        'ztlbbncthreeseven54three'                            | 33
        'eight8r6mcrcgrz51'                                   | 81
        'eightnines6nine75'                                   | 85
        'nhx83fivetwofivefourrvxqhnpeightwoj'                 | 82
        '857sixzrnine6dlprzx'                                 | 86
        'lteightwo2132seven7oneone'                           | 81
        '1516ldxxftfnineseven5'                               | 15
        '6fourfivej3'                                         | 63
        'sjmjp99'                                             | 99
        'bprsznhxztpp51'                                      | 51
        'cmfivetwo1four'                                      | 54
        '6mgcffzzspll15djsoneseven'                           | 67
        '9qjcvfourqdtmhlqzfxfg6'                              | 96
        'six45fivetwo3zkpxmxsgxtmg4'                          | 64
        'three12four72kvztxqdmfxhrxsp'                        | 32
        'threeninebnzthreedfqvm93kqmxpsnmb'                   | 33
        '8nzfbcmghfive92'                                     | 82
        '914six'                                              | 96
        'sevenfive6'                                          | 76
        '3bxxccqzdjsfive78lhtpbl'                             | 38
        '5zdvjxsfvcptngh5'                                    | 55
        'vboneight4six17'                                     | 17
        'seven8eight9krfhll3lnine'                            | 79
        'stv4eightonesixcfveight'                             | 48
        'rnmjpszvx94fivefzsphkkftgxpsfhvthsbv'                | 95
        'zmntmkcbgrtwonspdq7'                                 | 27
        '5ntxnjclc8six'                                       | 56
        '8six58five'                                          | 85
        '6ninesixeightqjnjfbbtlmcqvthree'                     | 63
        'hgjh9vhtdtcgkzpltnpxfqhsix7kq'                       | 97
        '64sevenc9'                                           | 69
        '96z62ninenine'                                       | 99
        'sevenseven38'                                        | 78
        'ckk9zdnkjvskct'                                      | 99
        '8flk7'                                               | 87
        '8eighthqntfrh'                                       | 88
        '8cthrxbjlxbnqvqc496htsltqpqktqnz'                    | 86
        '31threetwo5'                                         | 35
        'twofour5'                                            | 25
        'rlggcjdthj3nine'                                     | 39
        '18five4'                                             | 14
        'sevenhgncfjnseven1twoseven'                          | 77
        'kshqgsm3pcd518'                                      | 38
        '8qrpbpbbmzmbctsmvtddoneninefivetwofttd'              | 82
        'fivetwoqvtscrs133two5seven'                          | 57
        '6ninedcsrftdtwofivexzmpxdccnine3'                    | 63
        'threeseven73'                                        | 33
        'pppkjkgt3'                                           | 33
        'seven2six1ctmmjvdgj8h9'                              | 79
        'xkpk3fivemgmrfph'                                    | 35
        'pppgfivesixnineqxs6onebgsplgfhqp'                    | 51
        'cvjq15threesqqtpczr'                                 | 13
        'three95'                                             | 35
        'twoldjbdxnqncntpphxshbthree767kfqbsqhlkg'            | 27
        '9lfhbgmcqnhhlvvpvdtwo37'                             | 97
        'v7gj'                                                | 77
        '23fvgbbdjgst8'                                       | 28
        'six3frmpq'                                           | 63
        'zrggqtwo6sqr8'                                       | 28
        'fiverdrxxtjlhzn97fxsqpxf'                            | 57
        'sevenlpb2sj3one312'                                  | 72
        'four6six9fourjbsix7fnr'                              | 47
        'lpbgnkhkkbninec8three'                               | 93
        'spvkzsthfour2'                                       | 42
        'ljbrlhtkxfkskvdbgxqmmjn3nineqmqtffkfive9'            | 39
        'h1jmxtlfivenine1djqrsnpqccvzmdhsmxnqrjlgdlnj'        | 11
        '8threeseven'                                         | 87
        '1onefive6one71five'                                  | 15
        'qbjqnfsevenmls8gdnr66'                               | 76
        'jgpzsix76pxldgpcvdcpzn'                              | 66
        '8nkdjhgrn'                                           | 88
        'threeeighteight79'                                   | 39
        '9ninelzzrjqpkseven'                                  | 97
        '75six'                                               | 76
        'threebpfsn3three'                                    | 33
        '4twonel'                                             | 41
        'pjvmb14tzbz2tpfourfourseven'                         | 17
        'zslfour1pkklkrsixncvjtkn'                            | 46
        'honeight3'                                           | 13
        'six7stfffkjg'                                        | 67
        '42fourktbdmzstcgmdtcgbhffthree'                      | 43
        'two27'                                               | 27
        'ghvrgzj6six1'                                        | 61
        'vxjqk3xhlr3'                                         | 33
        'threetgzkjslbdrdxgfzsd3lcheight8ninebxhzf'           | 39
        'sixfive7one'                                         | 61
        'f5'                                                  | 55
        'qq6lkvlmrnseven9three'                               | 63
        '8fournine64rzdnnhgdsixseven'                         | 87
        '4vttbdfivesgdnjsvsxt6'                               | 46
        '765'                                                 | 75
        '6czbdlfcfkvplmcb'                                    | 66
        '7one52'                                              | 72
        'eight6neightone'                                     | 81
        'six5lttjtcbxmxnz'                                    | 65
        'threetwo692eight'                                    | 38
        'dhcztvmmlllg8four'                                   | 84
        'btdjgnh9vjvlqfkznqr635hhcr'                          | 95
        '2jvbxcfournine'                                      | 29
        '4sixonemp299sevenfour'                               | 44
        '1sixmdqkzqtgzeight7nine9'                            | 19
        '4nnhfkrlmfpseven'                                    | 47
        'blhvfourtwo5vrlqtqrlpxgd'                            | 45
        'kptg4eightvglvjdczfive'                              | 45
        '5599msgkplgqfnzseveneight6'                          | 56
        '3tnfvgftsnbzksnrhtrtlbfxcfqfjgnndlmfvkqvhcmgdtwo'    | 32
        'txvjfglxtbfive3zpx19'                                | 59
        'six9four5'                                           | 65
        '5fourseven'                                          | 57
        'fsevenmnfskhckvfszs73rnjqjhsseven'                   | 77
        '95knstccbfivepgpt'                                   | 95
        'kmtjfxtztqnrngxxgcgh1kdxpdjzspz'                     | 11
        'two2rtcmvpbzsmfourchpqthree99'                       | 29
        'fzteighteightlvnoneslhjmcrqrg8pzvszdxzbp'            | 88
        'one49szrxcjvtt3eighteight'                           | 18
        '8nqbmcsthreeninexf7'                                 | 87
        'fvvzvpmsgrrnhjksf8l4'                                | 84
        '7msxhtdk'                                            | 77
        'jgtwonetwosixthreervlmxlnine869lbqzxpqqn'            | 29
        'nvdn6bdg9ninesix'                                    | 66
        '82rxtf'                                              | 82
        '9tdqsdppseven7one'                                   | 91
        'tlbbxvtwo8one671bhghlhdpfh'                          | 21
        '3onethhhlmgfhseven'                                  | 37
        'n2six'                                               | 26
        '53eight'                                             | 58
        'one5five85'                                          | 15
        'three5375nine55'                                     | 35
        'fhvxvtjcnn3stcjhsdjtc1hhmk'                          | 31
        'six1jmgzrklbxrmzshpfgnv94hzfd'                       | 64
        '737six'                                              | 76
        '25nine'                                              | 29
        'fivevnpmlzvvp118lbv8xzplfttx8'                       | 58
        'ninethreesevensevensix4three2'                       | 92
        'xkgtqqlcdr51bgtx'                                    | 51
        'sixpddqmbb5onehbmjfbpqx3threechgvdkghhjhnxl'         | 63
        '7eight9sdcq1'                                        | 71
        '9ninejbcxzp'                                         | 99
        '3two2sixone'                                         | 31
        'seven8fiveonecrcqrglql141'                           | 71
        '4nine3cllndctlninecrdxsevenbhbqsgtjnchkmknpdht'      | 47
        'sevenzfbnvgfive3threesix'                            | 76
        'tvvjkskxgvfourxhccmmpxqx8mtxmfxmrcnine'              | 49
        'ptnnhktxxn2qrjvmddszgcftlpdfvxcpkm'                  | 22
        'mboneight8lbjvvfzrl8qgqf'                            | 18
        '7twomjfhzl'                                          | 72
        'sevendrdvmx2ninethree7seven2'                        | 72
        'zoneight6eightnldnvhqpbd5'                           | 15
        '29c'                                                 | 29
        'kzfkvqqs2ninesmlcrg573five'                          | 25
        'vxcgdz24ljhrhgsix6'                                  | 26
        'one3nine53xtr7seven'                                 | 17
        'djdeightwoeightc2six6nine'                           | 89
        'eight2727seventhreeone'                              | 81
        '3gdtc7llsdlftdrx'                                    | 37
        '581vjcbpmrzlp157jjcmlrzhr'                           | 57
        '7eightsix8fourgg69'                                  | 79
        'zsh38twocvklone'                                     | 31
        'three6np'                                            | 36
        '9tvxqtbpf77one7149'                                  | 99
        '7three3gqfpfqmhsfxqbqbnv'                            | 73
        '8rhflhmhtbm'                                         | 88
        '217onethreelgfmpdscnine98'                           | 28
        'three3stnst6xqqxvxzkfssevenbzktd7'                   | 37
        '46ttbnzlfnsjbc'                                      | 46
    }
}
