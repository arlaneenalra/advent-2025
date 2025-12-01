package com.thenextbug.advent2025.puzzleOne;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.stringtemplate.v4.compiler.STParser;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class HexMethodTest {
    private HexMethod method;

    @BeforeEach
    void setUp() {
        method = new HexMethod();
    }

    public static Stream<Arguments> data() {
        final StepResult pointer = new StepResult(0, 50);

        return Stream.of(
                Arguments.of(new StepResult(0, 95), new StepResult(1, 55), 60),
                Arguments.of(new StepResult(0, 0), new StepResult(0, 95), -5),
                Arguments.of(pointer, new StepResult(1, 82), -68),
                Arguments.of(pointer, new StepResult(1, 0), -50),
                Arguments.of(pointer, new StepResult(1, 50), -100),
                Arguments.of(pointer, new StepResult(2, 0), -150),
                Arguments.of(pointer, new StepResult(1, 0), 50),
                Arguments.of(pointer, new StepResult(1, 50), 100),
                Arguments.of(pointer, new StepResult(2, 0), 150)
        );
    }


    @ParameterizedTest
    @MethodSource("data")
    void testMoving(final StepResult pointer, final StepResult result, int value) {
        assertEquals(result, method.nextStep(pointer, value));
    }
}