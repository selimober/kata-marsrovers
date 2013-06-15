package com.selimober.marsrovers.io;

import com.selimober.marsrovers.domain.Plateau;
import com.selimober.marsrovers.domain.RoverInstruction;

import java.util.List;

/**
 * User: so
 * Date: 6/14/13
 */
public interface Parser {
    public Plateau parsePlateau();

    public List<RoverInstruction> parseInstructionList();
}
