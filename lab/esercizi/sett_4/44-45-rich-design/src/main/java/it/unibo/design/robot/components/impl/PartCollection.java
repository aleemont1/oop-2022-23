package it.unibo.design.robot.components.impl;

import java.util.Arrays;

import it.unibo.design.robot.components.api.RobotPart;
import it.unibo.design.robot.components.api.RobotPartCollection;
import it.unibo.design.robot.components.impl.AbstractPartCollection;

public class PartCollection extends AbstractPartCollection {

    public static final int DEFAULT_SIZE = 10;
    private RobotPart[] parts;
    private int index;

    public PartCollection(final int size) {
        this.parts = new RobotPart[Math.max(size, 1)];
        this.index = 0;
    }

    private void expand() {
        parts = Arrays.copyOf(parts, parts.length * 2);
    }

    private void shrink() {
        parts = Arrays.copyOf(parts, parts.length / 2);
    }

    public void connectPart(final RobotPart p) {
        if(index >= parts.length) {
            expand();
        }
        parts[index++] = p;
    }

    protected void removePart(final int i) {
        index--;
        if(index < getNumberOfParts() / 2) {
            shrink();
        }

        for(int j = i; j < index; j++) {
            parts[j] = parts[j + 1];
        }

        parts[index] = null;
    }

    protected int getNumberOfParts() {
        return index;
    }

    protected RobotPart getPart(final int i) {
        return parts[i];
    }
}
