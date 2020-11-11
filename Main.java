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
            System.out.println("Your tip percent is " + percent);
            inputInvalid = false;
        }
        return percent;
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Hello World");
        float bill = promptBillAmount(myObj), tip = 0.25f, total = 2.75f;
        int percentage = promptPercentage(myObj);
        System.out.println(bill);
        System.out.println(percentage);
        percentage = rateServer(myObj);
        System.out.println(percentage);

    }

}