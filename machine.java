
import java.util.Scanner;
// testing branch

public class machine {
    final static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {


        resources(0, 1, 2, 3, 4);

    }

    public static void resources(int water, int milk, int coffee, int cups, int money) {


        int[] ingridients = new int[5];
        ingridients[water] = 400;
        ingridients[milk] = 540;
        ingridients[coffee] = 120;
        ingridients[cups] = 9;
        ingridients[money] = 550;
		ingridients[6] = 100; // test

        action(ingridients, water, milk, coffee, money, cups);


    }

    public static void resourcesLeft(int[] ingridients, int subWater, int subMilk, int subCoffee, int subCups, int addMoney) {

        int water = 0;
        int milk = 1;
        int coffee = 2;
        int cups = 3;
        int money = 4;

        ingridients[water] -= subWater;
        ingridients[milk] -= subMilk;
        ingridients[coffee] -= subCoffee;
        ingridients[cups] -= subCups;
        ingridients[money] += addMoney;
    }

    public static void status(int[] ingridients, int water, int milk, int coffee, int money, int cups, int neededWater, int neededMilk,
                              int neededCoffee, int neededCups) {

        if (ingridients[water] < neededWater) {
            System.out.println("Sorry, not enough water!");
            action(ingridients, water, milk, coffee, money, cups);

        } else if (ingridients[milk] < neededMilk && ingridients[coffee] < neededCoffee) {
            System.out.println("Not enough ingridients!");
            action(ingridients, water, milk, coffee, money, cups);

        } else if (ingridients[cups] < neededCups) {
            System.out.println("Sorry, no cups!");
            action(ingridients, water, milk, coffee, money, cups);


        }

    }

    public static void action(int[] ingridients, int water, int milk, int coffee, int money, int cups) {

        while (true) {

            System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
            String action = scan.nextLine();

            if (action.equals("exit")) {
                break;

            }


            switch (action) {

                case "buy":
                    buy(ingridients, water, milk, coffee, money, cups);
                    break;
                case "fill":
                    fill(ingridients, water, milk, coffee, money, cups);
                    break;

                case "remaining":
                    remaining(ingridients, water, milk, coffee, money, cups);
                    break;
                case "take":
                    takeMoney(ingridients, money);
                    break;


            }
        }
    }

    public static void buy(int[] ingridients, int water, int milk, int coffee, int money, int cups) {

        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String buy = scan.nextLine();


        switch (buy) {
            case "1":
                status(ingridients, water, milk, coffee, money, cups, 250, 0, 16, 1);
                System.out.println("I have enough resources, making you a coffee!");
                resourcesLeft(ingridients, 250, 0, 16, 1, 4);
                break;


            case "2":
                status(ingridients, water, milk, coffee, money, cups, 350, 75, 20, 1);
                System.out.println("I have enough resources, making you a coffee!");
                resourcesLeft(ingridients, 350, 75, 20, 1, 7);
                break;

            case "3":
                status(ingridients, water, milk, coffee, money, cups, 200, 100, 12, 1);
                System.out.println("I have enough resources, making you a coffee!");
                resourcesLeft(ingridients, 200, 100, 12, 1, 6);
                break;

            case "back":
                break;

            default:
                break;


        }

    }

    public static void fill(int[] ingridients, int water, int milk, int coffee, int money, int cups) {

        System.out.println();
        System.out.println("Write how many ml of water do you want to add:");
        int addWater = Integer.parseInt(scan.nextLine());
        ingridients[water] += addWater;

        System.out.println("Write how many ml of milk do you want to add:");
        int addMilk = Integer.parseInt(scan.nextLine());
        ingridients[milk] += addMilk;

        System.out.println("Write how many grams of coffee beans do you want to add:");
        int addCoffee = Integer.parseInt(scan.nextLine());
        ingridients[coffee] += addCoffee;

        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int addCups = Integer.parseInt(scan.nextLine());
        ingridients[cups] += addCups;

        action(ingridients, water, milk, coffee, money, cups);


    }

    public static void remaining(int[] ingridients, int water, int milk, int coffee, int money, int cups) {

        System.out.println("\nThe coffee machine has:");
        System.out.println(ingridients[water] + " of water");
        System.out.println(ingridients[milk] + " of milk ");
        System.out.println(ingridients[coffee] + " of coffee beans");
        System.out.println(ingridients[cups] + " disposable cups");
        System.out.println("$" + ingridients[money] + " of money");


    }

    public static void takeMoney(int[] ingridients, int money) {
        System.out.println("\nI gave you " + "$" + ingridients[money]);
        ingridients[money] -= ingridients[money];


    }
}

