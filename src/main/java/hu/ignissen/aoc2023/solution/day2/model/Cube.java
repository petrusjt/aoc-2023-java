package hu.ignissen.aoc2023.solution.day2.model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Cube {
    private int cubeCount;
    private CubeType cubeType;

    private Cube() {}

    public static Cube from(final String recordString) {
        final var splitRecord = recordString.split(" ");

        final var gameRecord = new Cube();
        gameRecord.cubeCount = Integer.parseInt(splitRecord[0]);
        gameRecord.cubeType = CubeType.from(splitRecord[1]);
        return gameRecord;
    }

    public boolean isPossible(final int redLimit, final int greenLimit, final int blueLimit) {
        return switch (cubeType) {
            case RED -> cubeCount <= redLimit;
            case GREEN -> cubeCount <= greenLimit;
            case BLUE -> cubeCount <= blueLimit;
        };
    }
}
