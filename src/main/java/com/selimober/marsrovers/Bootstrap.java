package com.selimober.marsrovers;

import com.selimober.marsrovers.domain.NASA;
import com.selimober.marsrovers.domain.Plateau;
import com.selimober.marsrovers.domain.RoverInstruction;
import com.selimober.marsrovers.io.FileParser;
import com.selimober.marsrovers.io.Parser;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Instantiates NASA getting inputs from a file and starts the mission.
 *
 * User: so
 * Date: 6/15/13
 */
public class Bootstrap {
    public String run(File inputFile) throws IOException {
        Parser parser = new FileParser(inputFile);
        Plateau plateau = parser.parsePlateau();
        List<RoverInstruction> instructions = parser.parseInstructionList();

        NASA nasa = new NASA(plateau, instructions);
        return nasa.startMission();
    }
}
