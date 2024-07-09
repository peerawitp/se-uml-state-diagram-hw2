package models;

/**
 * @author 6510405741 Peerawit Pharkdeepinyo
 */
public class Machine {
    enum State {
        NO_QUARTER,
        HAS_QUARTER,
        GUMBALL_SOLD,
        OUT_OF_GUMBALLS
    }

    private State currentState;
    private int inventory;

    public Machine(int gumballAmount) {
        this.currentState = State.NO_QUARTER;
        this.inventory = gumballAmount;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public int getInventory() {
        return inventory;
    }

    public void getInfo() {
        System.out.println("Mighty Gumball, Inc.\nJava-enabled Standing Gumball Model #2004\nInventory: " + this.getInventory() + " gumballs");
        if (this.getCurrentState() == State.NO_QUARTER)
            System.out.println("Machine is waiting for quarter");
        else if (this.getCurrentState() == State.OUT_OF_GUMBALLS)
            System.out.println("Machine is sold out");
    }

    public void insertQuarter() {
        if (this.getCurrentState() == State.OUT_OF_GUMBALLS) {
            System.out.println("You can't insert a quarter, the machine is sold out");
        } else if (this.getCurrentState() == State.HAS_QUARTER) {
            System.out.println("You can't insert another quarter");
        } else if (this.getCurrentState() == State.NO_QUARTER) {
            System.out.println("You inserted a quarter");
            this.setCurrentState(State.HAS_QUARTER);
        }
    }

    public void turnCrank() {
        if (this.getCurrentState() == State.HAS_QUARTER) {
            System.out.println("You turned..");
            this.setCurrentState(State.GUMBALL_SOLD);
            dispenseGumball();
        }
        else if (this.getCurrentState() == State.NO_QUARTER)
            System.out.println("You turned but there's no quarter");
        else if (this.getCurrentState() == State.OUT_OF_GUMBALLS)
            System.out.println("You turned but there's no gumballs");
    }

    public void dispenseGumball() {
        if (this.inventory > 0) {
            inventory--;
            System.out.println("A gumball comes rolling out the slot");
            this.setCurrentState(State.NO_QUARTER);
        }

        if (this.inventory == 0) {
            this.setCurrentState(State.OUT_OF_GUMBALLS);
            System.out.println("Oops, out of gumballs!");
        }
    }

    public void ejectQuarter() {
        if (this.getCurrentState() == State.HAS_QUARTER) {
            this.setCurrentState(State.NO_QUARTER);
            System.out.println("Quarter returned");
        }
        else if (this.getCurrentState() == State.NO_QUARTER) {
            System.out.println("You haven't inserted a quarter");
        }
    }
}