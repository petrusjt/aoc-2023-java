package hu.ignissen.aoc2023.common.exception;

import lombok.experimental.StandardException;

@StandardException
public class FileNotFoundException extends RuntimeException {

    public FileNotFoundException(final String message) {
        super(message);
    }
}
