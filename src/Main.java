import models.Machine;

/**
 * @author 6510405741 Peerawit Pharkdeepinyo
 */
public class Main {
    public static void main(String[] args) {
        Machine machine = new Machine(5);
        machine.getInfo();

        System.out.println();
        machine.insertQuarter();
        machine.turnCrank();

        System.out.println();
        machine.getInfo();

        System.out.println();
        machine.insertQuarter();
        machine.ejectQuarter();
        machine.turnCrank();

        System.out.println();
        machine.getInfo();

        System.out.println();
        machine.insertQuarter();
        machine.turnCrank();
        machine.insertQuarter();
        machine.turnCrank();
        machine.ejectQuarter();

        System.out.println();
        machine.getInfo();

        System.out.println();
        machine.insertQuarter();
        machine.insertQuarter();
        machine.turnCrank();
        machine.insertQuarter();
        machine.turnCrank();
        machine.insertQuarter();
        machine.turnCrank();

        System.out.println();
        machine.getInfo();
    }
}