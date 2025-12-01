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
    private static final Pattern CMD_MATHER = Pattern.compile("([LR])([0-9]+)");

    @Command(description = "The first puzzle: https://adventofcode.com/2025/day/1")
    public void firstPuzzle(final CommandContext context, @Nonnull final String passwordFile) throws IOException {
        final String instructions = Files.readString(Path.of(passwordFile));

        final String[] lines = instructions.split("\\r?\\n");
        log.info("First Puzzle Instructions: {}", lines.length);

        int pointer = 50;
        int zeros = 0;
        for (final String line : lines) {
            final var matcher = CMD_MATHER.matcher(line);

            if (!matcher.matches()) {
                log.warn("Wrong Puzzle Instructions: {}", line);
                continue;
            }

            final String cmd = matcher.group(1);
            final int value = Integer.parseInt(matcher.group(2)) % 100;

            pointer = pointer + ("L".equals(cmd) ? -value : value);

            if (pointer > 99) {
                pointer = pointer - 100;
            } else if (pointer < 0) {
                pointer = pointer + 100;
            }

            if (pointer == 0) {
                zeros++;
            }

            log.info("Puzzle Instructions: {} {} -> {}", cmd, value, pointer);
        }

        log.info("Found {} zeros", zeros);
    }
}
