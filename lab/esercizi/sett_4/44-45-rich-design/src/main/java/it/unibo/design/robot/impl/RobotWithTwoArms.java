package it.unibo.design.robot.impl;

import it.unibo.design.robot.api.RobotWithArms;

public class RobotWithTwoArms extends BaseRobot implements RobotWithArms {

    private BasicArm leftArm;
    private BasicArm rightArm;

    public RobotWithTwoArms(final String name) {
        super(name);
        leftArm = new BasicArm("Left Arm");
        rightArm = new BasicArm("Right Arm");
    }

    public boolean pickUp() {
        if(leftArm.isGrabbing()) {
            if(rightArm.isGrabbing()) {
                return false;
            }           
            grab(leftArm);
        } else {
            grab(rightArm);
        }

        return true;
    }

    public boolean dropDown() {
        if(leftArm.isGrabbing()) {
            drop(leftArm);
            return true;
        }
        if(rightArm.isGrabbing()) {
            drop(rightArm);
            return true;
        }
        return false;
    }

    private void grab(final BasicArm arm) {
        if(super.isBatteryEnough(arm.getConsumptionForPickUp()) && !arm.isGrabbing()) {
            log(arm + "Picking up");
            arm.pickUp();
            super.consumeBattery(arm.getConsumptionForPickUp());
        } else {
            log(arm + "Can't pick up (Battery: " + super.getBatteryLevel() + "), isGrabbing: "
                     + arm.isGrabbing());
        }
    }

    private void drop(final BasicArm arm) {
        if(super.isBatteryEnough(arm.getConsumptionForDropDown()) && arm.isGrabbing()) {
            log(arm + "Dropping down");
            arm.dropDown();
            super.consumeBattery(arm.getConsumptionForDropDown());
        } else {
            log(arm + "Can't drop down (Battery: " + super.getBatteryLevel() + "), isGrabbing: "
                     + arm.isGrabbing());
        }
    }

    public int getCarriedItemsCount() {
        return (leftArm.isGrabbing() ? 1 : 0) + (rightArm.isGrabbing() ? 1 : 0);
    }
}