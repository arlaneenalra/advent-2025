package com.thenextbug.advent2025.puzzleOne;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

@Slf4j
public abstract class BasePasswordMethod implements PasswordMethod {
    private static final Pattern CMD_MATHER = Pattern.compile("([LR])([0-9]+)");

    @Override
    public int getZeros(final String passwordFile) throws IOException {
        final String instructions = Files.readString(Path.of(passwordFile));

        final String[] lines = instructions.split("\\r?\\n");
        log.info("First Puzzle Instructions: {}", lines.length);


        StepResult step = new StepResult(0, 50);
        for (final String line : lines) {
            final var matcher = CMD_MATHER.matcher(line);

            if (!matcher.matches()) {
                log.warn("Wrong Puzzle Instructions: {}", line);
                continue;
            }

            final String cmd = matcher.group(1);
            final int value = Integer.parseInt(matcher.group(2));

            final StepResult after = nextStep(step, ("L".equals(cmd) ? -value : value));

            log.info("Puzzle Instructions: {} = {} ->  {}", line, step, after);

            if (after.zeros() != step.zeros()) {
                log.info("Delta Zero {}", after.zeros() - step.zeros());
            }

            step = after;
        }

        return step.zeros();
    }

    abstract StepResult nextStep(final StepResult previous, int stepValue);

}
