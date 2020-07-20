package machine;
import java.util.*;

public class CoffeeMachine {

    int money;
    int water;
    int milk;
    int beans;
    int cups;

    /** Constructor**/
    public CoffeeMachine(int money, int water, int milk, int beans, int cups) {
        this.money = money;
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
    }

    /** Print supply of coffee machine **/
    public void printSupply() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println("$" + money + " of money" + '\n');
    }

    /** Ask which coffee to make and subtract or add amount to
     * supplys and money.
     *  **/
    public void buyCoffee() {

        final int waterEspresso = 250;
        final int beansEspresso = 16;
        final int moneyEspresso = 4;
        final int waterLatte = 350;
        final int milkLatte = 75;
        final int beansLatte = 20;
        final int moneyLattee = 7;
        final int waterCappu = 200;
        final int milkCappu = 100;
        final int beansCappu = 12;
        final int moneyCappu = 6;

        Scanner scanner = new Scanner(System.in);
        String option;
        boolean quit = false;
        do {
            System.out.println("What do you want to buy?" +
                    "1 - espresso, 2 - latte, 3 - cappucciono," +
                    "back - to main menu:");
            option = scanner.nextLine();

            if (option != "back" && cups == 0) {
                System.out.println("Sorry, not enough disposable" +
                        "cups!\n");
                return;
            }

            switch (option) {
                case "back": return;
                case "1":
                    if (water < waterEspresso) {
                        System.out.println("Sorry, not enough " +
                                "water!\n");
                        return;
                    } else if (beans < beansEspresso) {
                        System.out.println("Sorry, not enough " +
                                "beans!\n");
                        return;
                    } else {
                        System.out.println("I have enough " +
                                "resources, making you a coffee!\n");
                        water -= waterEspresso;
                        beans -= beansEspresso;
                        money += moneyEspresso;
                        cups--;
                    }
                    break;
                case "2":
                    if (water < waterLatte) {
                        System.out.println("Sorry, not enough " +
                                "water!\n");
                        return;
                    } else if (milk < milkLatte) {
                        System.out.println("Sorry, not enough " +
                                "milk!\n");
                        return;
                    } else if (beans < beansLatte) {
                        System.out.println("Sorry, not enough " +
                                "beans!\n");
                        return;
                    } else {
                        System.out.println("I have enough " +
                                "resources, making you a coffee!\n");
                        water -= waterLatte;
                        milk -= milkLatte;
                        beans -= beansLatte;
                        money += moneyLattee;
                        cups--;
                    }
                    break;
                case "3":
                    if (water < waterCappu) {
                        System.out.println("Sorry, not enough " +
                                "water!\n");
                        return;
                    } else if (milk < milkCappu) {
                        System.out.println("Sorry, not enough " +
                                "milk!\n");
                        return;
                    } else if (beans < beansCappu) {
                        System.out.println("Sorry, not enough " +
                                "beans!\n");
                        return;
                    } else {
                        water -= waterCappu;
                        milk -= milkCappu;
                        beans -= beansCappu;
                        money += moneyCappu;
                        cups--;
                    }
                    break;
                default:
                    System.out.println("Option does not exist!\n");
                    quit = true; // Continue this do loop
                    break;
            }
        } while (quit);
    }

    /** Ask the amount to fill the machine **/
    public void fillMachine() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water do you " +
                "want to add:");
        int dWater = scanner.nextInt();
        System.out.println("Write how many ml of milk do you " +
                "want to add: ");
        int dMilk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans" +
                " do you want to add: ");
        int dBeans = scanner.nextInt();
        System.out.println("Write how many disposable cups " +
                "of coffee do you want to add:");
        int dCups = scanner.nextInt();

        water += dWater;
        milk += dMilk;
        beans += dBeans;
        cups += dCups;

    }

    /** Take specific amount of money out of machine **/
    public void takeMoney() {
        if (money > 0) {
            System.out.println("I gave you $" + money);
            System.out.print('\n');
            money = 0;
        } else {
            System.out.println("No money left!");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        CoffeeMachine machine = new CoffeeMachine(550, 400, 540,
                120, 9);

        for (;;) {
            System.out.println("Write action " +
                    "(buy, fill, take, remaining, exit):");
            String input = scanner.nextLine();

            switch (input) {
                case "exit":
                    System.exit(0);
                case "buy":
                    machine.buyCoffee();
                    break;
                case "fill":
                    machine.fillMachine();
                    break;
                case "take":
                    machine.takeMoney();
                    break;
                case "remaining":
                    machine.printSupply();
                    break;
                default:
                    System.out.println("Command does not exist!");
                    break;
            }
        }
    }
}
