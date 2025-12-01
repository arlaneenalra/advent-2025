package com.thenextbug.advent2025.config;

import com.thenextbug.advent2025.puzzleOne.PuzzleOne;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.command.annotation.EnableCommand;

@Configuration
@EnableCommand({PuzzleOne.class})
public class CommandConfig {
}
