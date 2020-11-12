import java.util.Scanner;
import java.util.HashMap;

public class Main {

    //Prompts the user for the cost of their bill
    private static float promptBillAmount(Scanner myObj) {
        boolean inputInvalid = true;
        float cost = 0.00f;


        while (inputInvalid == true) {
/*             while (!myObj.hasNextFloat()) {
                System.out.println("float please");
                myObj.nextFloat();
            }
            try { */
            System.out.print("Please enter the cost of your bill: $");
            cost = myObj.nextFloat();
            inputInvalid = false;
/*             } catch(Exception e) {
                System.out.println("Invalid Number. Please enter a specific amount. (Ex: $12.50)");
                System.out.println(e);
            } */
        }
        return cost;
    }

    //Prompts the user for a percentage to use for calculating a tip
    private static int promptPercentage(Scanner myObj) {
        int percent = 0;
        boolean inputInvalid = true;

        while (inputInvalid == true) {
            // try {
                System.out.print("Please enter the percentage of the tip you'd like to give (Whole numbers only): ");
                percent = myObj.nextInt();
                inputInvalid = false;
/*             } catch(Exception e) {
                System.out.println("Invalid Number. Please provide only a whole number. (Ex: 20)");
            } */
        }
        return percent;
    }

    //A hashmap designed to convert a rating into a percent
    private static int ratingToPercent(int rating) {
        HashMap<Integer, Integer> percentHash = new HashMap<Integer, Integer>();
        percentHash.put(1, 5);
        percentHash.put(2, 10);
        percentHash.put(3, 15);
        percentHash.put(4, 25);
        percentHash.put(5, 35);
        return percentHash.get(rating);
    }

    private static int rateServer(Scanner myObj) {
        int percent = 0, rating = 0;
        boolean inputInvalid = true;
        while (inputInvalid == true) {
            System.out.print("Please give your server a rating between 1 and 5 stars: ");
            rating = myObj.nextInt();
            percent = ratingToPercent(rating);
            System.out.println("Your tip percent is " + percent + ".");
            inputInvalid = false;
        }
        return percent;
    }

    private static float promptTipAmount(Scanner myObj) {
        boolean inputInvalid = true;
        float tip = 0.00f;
        while (inputInvalid == true) {
            System.out.print("Please enter the amount you'd like to tip: $");
            tip = myObj.nextFloat();
            inputInvalid = false;
        }
        return tip;
    }

    private static float percentToTip(int percent, float bill) {
        return bill * ((float) percent / 100);
    }

    private static float getTip(float bill, Scanner myObj) {
        float tip = 0.00f;
        String userInput = "a";
        var inputInvalid = true;
        myObj.nextLine();
        while (inputInvalid == true) {
            System.out.println("------------------------------------------------------------------");
            System.out.println("How would you like to calculate your tip?");
            System.out.println("Type 'p' to input a percentage.");
            System.out.println("Type 'q' to calculate a price based on the quality of your server.");
            System.out.println("Type 'm' to manually input a tip amount.");
            System.out.println("------------------------------------------------------------------");
            System.out.print(">");
            userInput = myObj.nextLine();
            if (userInput.equals("p") || userInput.equals("q") || userInput.equals("m")) {
                inputInvalid = false;
            }
        }
        if (userInput.equals("p")) {
            tip = percentToTip(promptPercentage(myObj), bill);
        }
        else if (userInput.equals("q")) {
            tip = percentToTip(rateServer(myObj), bill);
        }
        else if (userInput.equals("m")) {
            tip = promptTipAmount(myObj);
        }
        return tip;
    }

    private static float calculateTotal(float bill, float tip) {
        float total = 0.00f;
        total = bill + tip;
        return total;
    }

    private static void displayTotal(float total) {
        System.out.println("Your total is $" + String.format("%.2f", total) + ".");
    }
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        float bill = promptBillAmount(myObj), tip = getTip(bill, myObj), total = calculateTotal(bill, tip);
        displayTotal(total);
    }

}