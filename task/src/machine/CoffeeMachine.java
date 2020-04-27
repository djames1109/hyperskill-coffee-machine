package machine;

import java.util.Scanner;

/**
 * The coffee machine needs 200 ml of water, 50 ml of milk, and 15 g of coffee beans
 */
public class CoffeeMachine {
    private static final String BUY = "buy";
    private static final String FILL = "fill";
    private static final String TAKE = "take";
    private static final String REMAINING = "remaining";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        AbstractMachine machine = new Machine(400, 540, 120, 9, 550);

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scan.next();

            if (BUY.equalsIgnoreCase(action)) {
                machine.buy();
            } else if (FILL.equalsIgnoreCase(action)) {
                machine.fill();
            } else if (TAKE.equalsIgnoreCase(action)) {
                machine.take();
            } else if (REMAINING.equalsIgnoreCase(action)) {
                machine.remaining();
            } else {
                break;
            }
        }
    }
}
