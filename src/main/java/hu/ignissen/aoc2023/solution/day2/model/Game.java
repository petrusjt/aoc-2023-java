package hu.ignissen.aoc2023.solution.day2.model;

import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ToString
public class Game {
    @Getter
    private int id;
    private List<CubeSet> cubeSets;

    private Game() {}

    public static Game from(String line) {
        final var splitLine = line.split(":");
        final var game = new Game();
        game.id = Integer.parseInt(splitLine[0].split(" ")[1]);
        game.cubeSets = Arrays.stream(splitLine[1].split(";"))
                .map(StringUtils::strip)
                .map(CubeSet::from)
                .toList();
        return game;
    }

    public boolean isPossible(final int redLimit, final int greenLimit, final int blueLimit) {
        return cubeSets.stream()
                .allMatch(cubeSet -> cubeSet.isPossible(redLimit, greenLimit, blueLimit));
    }

    public int getMinimumSetPower() {
        final List<Integer> minimumSet = getMinimumSet();
        var power = 1;
        for (var item : minimumSet) {
            power *= item;
        }
        return power;
    }

    private List<Integer> getMinimumSet() {
        final List<Integer> minimumCubeNumbers = new ArrayList<>();
        for (final var cubeType : CubeType.values()) {
            cubeSets.stream()
                    .flatMap(cubeSet -> cubeSet.getCubes().stream())
                    .filter(cube -> cube.getCubeType() == cubeType)
                    .mapToInt(Cube::getCubeCount)
                    .max().ifPresent(minimumCubeNumbers::add);
        }
        return minimumCubeNumbers;
    }
}
