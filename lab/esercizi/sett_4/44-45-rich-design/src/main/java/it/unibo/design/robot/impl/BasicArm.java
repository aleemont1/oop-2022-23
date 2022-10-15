package it.unibo.design.robot.impl;

public class BasicArm {
    private static final double MOVE_CONSUMPTION = 0.2;
    private static final double GRAB_CONSUMPTION = 0.1;
    private boolean grabbing;
    private final String name;

    public BasicArm(String name) {
        this.name = name;
    }
    public boolean isGrabbing() {
        return grabbing;
    }

    public void pickUp() {
        grabbing = true;
    }

    public void dropDown() {
        grabbing = false;
    }

    /*public double getConsumption() {
        return (grabbing ? GRAB_CONSUMPTION : 0) + MOVE_CONSUMPTION;        //Would have reduced the number of lines of code and methods.
    }*/

    public double getConsumptionForPickUp() {
        return GRAB_CONSUMPTION + MOVE_CONSUMPTION;
    }

    public double getConsumptionForDropDown() {
        return MOVE_CONSUMPTION;
    }

    public String toString() {
        return name;
    }
}
