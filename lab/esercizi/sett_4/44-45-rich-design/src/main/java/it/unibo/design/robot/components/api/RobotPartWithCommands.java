package it.unibo.design.robot.components.api;

import it.unibo.design.robot.components.api.RobotPart;

public interface RobotPartWithCommands extends RobotPart {
    
    void sendCommand(String command);

    String[] getCommands();
}
