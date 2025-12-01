package com.thenextbug.advent2025.puzzleOne;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HexMethod extends BasePasswordMethod {

    @Override
    StepResult nextStep(StepResult previous, int stepValue) {
        int pointer = previous.pointer();
        int zeros = previous.zeros();

        zeros += (stepValue / 100) * (stepValue < 0 ? -1 : 1);
        stepValue = stepValue % 100;
        pointer += stepValue;

        if (pointer >= 100) {
            zeros+= (previous.pointer() == 0 ? 0: 1);
            pointer = pointer % 100;
        } else if (pointer < 0) {
            zeros+= (previous.pointer() == 0 ? 0: 1);
            pointer = 100 + (pointer % 100);
        } else if ( pointer == 0) {
            zeros++;
        }

        return new StepResult(zeros, pointer);
    }
}
