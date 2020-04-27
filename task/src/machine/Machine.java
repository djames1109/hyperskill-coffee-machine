package machine;

import java.util.Scanner;

import static machine.Coffee.*;

public class Machine extends AbstractMachine {

    private Scanner scan = new Scanner(System.in);
    private int water;
    private int milk;
    private int coffeeBeans;
    private int cups;
    private int money;

    public Machine(int water, int milk, int coffeeBeans, int cups, int money) {
        super();
        this.water = water;
        this.milk = milk;
        this.coffeeBeans = coffeeBeans;
        this.cups = cups;
        this.money = money;
    }

    @Override
    public void remaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println("$" + money + " of money");
    }

    @Override
    public void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        this.water += scan.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        this.milk += scan.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        this.coffeeBeans += scan.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        this.cups += scan.nextInt();
    }

    @Override
    public void take() {
        System.out.println("I gave you $" + money);
        money -= money;
    }

    @Override
    public void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        switch (scan.next()) {
            case "1":
                buyEspresso();
                break;
            case "2":
                buyLatte();
                break;
            case "3":
                buyCappuccino();
                break;
            default:
                break;
        }
    }

    private void buyEspresso() {
        if (isEnough(ESPRESSO)) {
            water -= ESPRESSO.getWater();
            coffeeBeans -= ESPRESSO.getCoffeeBeans();
            money += ESPRESSO.getCost();
            cups -= 1;
            System.out.println("I have enough resources, making you a coffee!");
        }
    }

    private void buyLatte() {
        if (isEnough(LATTE)) {
            water -= LATTE.getWater();
            milk -= LATTE.getMilk();
            coffeeBeans -= LATTE.getCoffeeBeans();
            money += LATTE.getCost();
            cups -= 1;
            System.out.println("I have enough resources, making you a coffee!");
        }
    }

    private void buyCappuccino() {
        if (isEnough(CAPPUCCINO)) {
            water -= CAPPUCCINO.getWater();
            milk -= CAPPUCCINO.getMilk();
            coffeeBeans -= CAPPUCCINO.getCoffeeBeans();
            money += CAPPUCCINO.getCost();
            cups -= 1;
            System.out.println("I have enough resources, making you a coffee!");
        }
    }

    private boolean isEnough(Coffee coffee) {
        if (this.water < coffee.getWater()) {
            System.out.println("Sorry, not enough water!");
        } else if (this.milk < coffee.getMilk()) {
            System.out.println("Sorry, not enough milk!");
        } else if (this.coffeeBeans < coffee.getCoffeeBeans()) {
            System.out.println("Sorry, not enough coffee beans");
        } else if (this.cups < 1) {
            System.out.println("Sorry, not enough disposable cups");
        } else {
            return true;
        }
        return false;
    }
}
