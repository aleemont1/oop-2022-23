package it.unibo.design.robot.components.impl;

public class RobotArm extends AbstractPartWithCommands {

    protected static final double CONSUMPTION = 0.2;
    protected static final String PICK = "Pick";
    protected static final String DROP = "Drop";
    private boolean grabbing;

    public RobotArm(final String name) {
        super(name, CONSUMPTION, PICK, DROP);
    }

    public boolean activate(final String command) {
        System.out.println(this + " Received command: " + command);
        if(RobotArm.PICK.equals(command)) {
            if(this.grabbing) {
                System.out.println(this + "Already grabbing");
                return false;
            }
            grabbing = true;
            return true;
        }

        if(RobotArm.DROP.equals(command)) {
            if(!this.grabbing) {
                System.out.println(this + "Not grabbing");
                return false;
            }
            grabbing = false;
            return true;
        }
        System.out.println("Unknown command: " + command);
        return false;
    }

    public String toString() {
        return super.getName();
    }
}
