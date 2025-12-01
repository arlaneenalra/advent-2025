package com.thenextbug.advent2025.puzzleOne;

public class ZeroCounter extends BasePasswordMethod {

    @Override
    StepResult nextStep(StepResult previous, int stepValue) {
        int pointer = previous.pointer();
        int zeros = previous.zeros();

        stepValue = stepValue % 100;
        pointer += stepValue;

        if (pointer > 99) {
            pointer = pointer - 100;
        } else if (pointer < 0) {
            pointer = pointer + 100;
        }

        if (pointer == 0) {
            zeros++;
        }

        return new StepResult(zeros, pointer);
    }
}
