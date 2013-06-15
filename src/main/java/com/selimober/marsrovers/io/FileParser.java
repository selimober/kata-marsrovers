package com.selimober.marsrovers.io;

import com.selimober.marsrovers.domain.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * User: so
 * Date: 6/14/13
 */
public class FileParser implements Parser {

    private static final int PLATEAU_LINE_NUMBER = 0;

    private List<String> inputLines;

    public FileParser(File file) throws IOException {
        inputLines = parseLines(file);
    }

    @Override
    public Plateau parsePlateau() {
        String plateauLine = inputLines.get(PLATEAU_LINE_NUMBER);
        int width = Integer.parseInt(plateauLine.split(" ")[0]);
        int height = Integer.parseInt(plateauLine.split(" ")[1]);
        return new Plateau(width, height);
    }

    @Override
    public List<RoverInstruction> parseInstructionList() {
        List<RoverInstruction> instructions = new ArrayList<RoverInstruction>();
        for (int i = 1; i < inputLines.size(); i++) {
            Position initialPosition = parseInitialPosition(inputLines.get(i++));
            List<Command> commands = parseCommands(inputLines.get(i));
            instructions.add(new RoverInstruction(initialPosition, commands));
        }
        return instructions;
    }

    private List<Command> parseCommands(String commands) {
        char[] commandChars = commands.toCharArray();
        List<Command> commandList = new ArrayList<Command>();
        for (int i = 0; i < commandChars.length; i++) {
            char commandChar = commandChars[i];
            commandList.add(Command.fromChar(commandChar));
        }
        return commandList;
    }

    private Position parseInitialPosition(String initialPosition) {
        int x = Integer.parseInt(initialPosition.split(" ")[0]);
        int y = Integer.parseInt(initialPosition.split(" ")[1]);
        String directionAbbr = initialPosition.split(" ")[2];
        Direction direction = Direction.fromChar(directionAbbr.charAt(0));
        return new Position(x, y, direction);
    }

    private List<String> parseLines(File file) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        List<String> lines = new ArrayList<String>();
        String line;
        while ((line = br.readLine()) != null) {
            lines.add(line);
        }
        return lines;
    }
}
