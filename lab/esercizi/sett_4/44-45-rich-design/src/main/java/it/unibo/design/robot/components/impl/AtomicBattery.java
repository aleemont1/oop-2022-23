package it.unibo.design.robot.components.impl;

public class AtomicBattery extends AbstractPart {

    public AtomicBattery() {
        super("Atomic Battery", 0);
    }

    public String toString() {
        return "Atomic Battery";
    }

    public boolean activate() {
        if(isOn() && isConnected()) {
            super.getRobot().recharge();
            System.out.println(this + " charged the battery to" + getRobot().getBatteryLevel());
            return true;
        }
        return true;
    }
}
