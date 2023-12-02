package hu.ignissen.aoc2023.solution.day2.model;

public enum CubeType {
    RED,
    GREEN,
    BLUE;

    public static CubeType from(String string) {
        return switch (string) {
            case "red" -> RED;
            case "green" -> GREEN;
            case "blue" -> BLUE;
            default -> throw new IllegalArgumentException("Unknown colour");
        };
    }
}
