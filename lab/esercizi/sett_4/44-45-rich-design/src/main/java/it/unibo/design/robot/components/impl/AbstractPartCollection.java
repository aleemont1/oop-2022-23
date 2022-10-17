package it.unibo.design.robot.components.impl;

import it.unibo.design.robot.components.api.RobotPart;
import it.unibo.design.robot.components.api.RobotPartCollection;

public abstract class AbstractPartCollection implements RobotPartCollection {
        
    private int index;

    public abstract int getNumberOfParts();
    public abstract RobotPart getPart(int i);
    public abstract void removePart(int i);

    @Override
    public final void resetIterator() {
        index = 0;
    }

    @Override
    public final boolean hasNext() {
        return index < getNumberOfParts();
    }

    @Override
    public final RobotPart next() {
        if(hasNext()) {
            return getPart(index++);
        }
        return null;
    }

    @Override
    public final void disconnect(RobotPart p) {
        for (int i = 0; i < getNumberOfParts(); i++) {
            if (getPart(i) == p) {
                removePart(i);
                return;
            }
        }
    }
}
