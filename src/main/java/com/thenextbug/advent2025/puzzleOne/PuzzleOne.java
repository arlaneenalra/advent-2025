package com.thenextbug.advent2025.puzzleOne;

import jakarta.annotation.Nonnull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.shell.command.CommandContext;
import org.springframework.shell.command.annotation.Command;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.regex.Pattern;

@Command
@Slf4j
public class PuzzleOne {


    @Command(description = "The first puzzle: https://adventofcode.com/2025/day/1")
    public void firstPuzzle(final CommandContext context, @Nonnull final String passwordFile) throws IOException {
        final PasswordMethod method = new ZeroCounter();

        var zeros = method.getZeros(passwordFile);

        log.info("Found {} zeros", zeros);
    }

    @Command(description = "Part 2 password method 0x434C49434B")
    public void firstPuzzlePart2(final CommandContext context, @Nonnull final String passwordFile) throws IOException {
        final PasswordMethod method = new HexMethod();

        var zeros = method.getZeros(passwordFile);

        log.info("Found {} zeros", zeros);
    }
}
