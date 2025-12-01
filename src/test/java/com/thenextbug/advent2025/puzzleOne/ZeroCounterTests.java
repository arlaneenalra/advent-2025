package com.thenextbug.advent2025.puzzleOne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ZeroCounterTests {
    private ZeroCounter zeroCounter;

    @BeforeEach
    void setUp() {
        zeroCounter = new ZeroCounter();
    }

    public static Stream<Arguments> data() {
        return Stream.of(
                Arguments.of(new StepResult(1, 0), -50),
                Arguments.of(new StepResult(0, 50), -100),
                Arguments.of(new StepResult(1, 0), -150),
                Arguments.of(new StepResult(1, 0), 50),
                Arguments.of(new StepResult(0, 50), 100),
                Arguments.of(new StepResult(1, 0), 150)
        );
    }


    @ParameterizedTest
    @MethodSource("data")
    void testMoving(final StepResult result, int value) {
        final StepResult pointer = new StepResult(0, 50);

        assertEquals(result, zeroCounter.nextStep(pointer, value));
    }
}
