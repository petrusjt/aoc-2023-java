package hu.ignissen.aoc2023.solution.day2.model;

import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@ToString
public class CubeSet {
    private List<Cube> cubes;

    private CubeSet() {}

    public static CubeSet from(final String cubeSetString) {
        final var cubeSet = new CubeSet();
        cubeSet.cubes = Arrays.stream(cubeSetString.split(","))
                .map(StringUtils::strip)
                .map(Cube::from)
                .toList();
        return cubeSet;
    }

    public boolean isPossible(final int redLimit, final int greenLimit, final int blueLimit) {
        return cubes.stream()
                .allMatch(cube -> cube.isPossible(redLimit, greenLimit, blueLimit));
    }
}
