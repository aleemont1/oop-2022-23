package it.unibo.design.robot.components.impl;

import it.unibo.design.robot.components.api.RobotPart;
import it.unibo.design.robot.components.api.RobotPartCollection;

public abstract class AbstractPartCollection implements RobotPartCollection {

    private RobotPart[] parts;
    private int index;

    public AbstractPartCollection(final RobotPart[] parts) {
        this.parts = parts;
        this.index = 0;
    }

    public void connectPart(final RobotPart p) {
        for (int i = 0; i < parts.length; i++) {
            if (parts[i] == null) {
                parts[i] = p;
                return;
            }
        }
    }

    public void resetIterator() {
        index = 0;
    }

    public boolean hasNext() {
        return index < parts.length;
    }

    public RobotPart next() {
        return parts[index++];
    }

    public void disconnect(final RobotPart p) {
        for (int i = 0; i < parts.length; i++) {
            if (parts[i] == p) {
                parts[i] = null;
                return;
            }
        }
    }

}
