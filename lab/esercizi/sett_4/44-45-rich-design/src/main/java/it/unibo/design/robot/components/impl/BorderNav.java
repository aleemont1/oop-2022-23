package it.unibo.design.robot.components.impl;

import it.unibo.design.robot.impl.BaseRobot;

public class BorderNav extends AbstractPart  {
    
    private static final int NORTH = 0;
    private static final int EAST = 1;
    private static final int SOUTH = 2;
    private static final int WEST = 3;
    private static final int AVAILABLE_DIRS = 4;
    private int currentDir;

    public BorderNav() {
        super("BorderNav", BaseRobot.MOVEMENT_DELTA_CONSUMPTION);
    }

    @Override
    public String toString() {
        return "BorderNav";
    }

    private boolean move() {
        switch(currentDir % AVAILABLE_DIRS) {
            case NORTH:
                return getRobot().moveUp();
            case EAST:
                return getRobot().moveRight();
            case SOUTH:
                return getRobot().moveDown();
            case WEST:
                return getRobot().moveLeft();
            default:
                System.out.println("There is a problem with the current direction" + getClass());
                return false;
        }
    }
    
    @Override  
    public boolean activate() {
        if(isOn() && isConnected()) {
            while(!move()) {
                currentDir++;
                if(currentDir > AVAILABLE_DIRS) {
                    currentDir = 0;
                }
            }
            return true;
        }
            return false;
    }
}
