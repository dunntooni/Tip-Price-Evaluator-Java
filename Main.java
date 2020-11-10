import java.util.Scanner;

public class Main {

    //Prompts the user for the cost of their bill
    private static float promptBillAmount() {
        boolean inputInvalid = true;
        float cost = 0.00f;
        
        while (inputInvalid == true) {
            try {
                Scanner myObj = new Scanner(System.in);
                System.out.print("Please enter the cost of your bill: $");
                cost = myObj.nextFloat();
                inputInvalid = false;
                myObj.close();
            } catch(Exception e) {
                System.out.println("Invalid Number. Please enter a specific amount. (Ex: $12.50)");
            }
        }
        
        return cost;
    }


    public static void main(String[] args) {
        System.out.println("Hello World");
        float bill = promptBillAmount(), tip = 0.25f, total = 2.75f;
        System.out.println(bill);

    }

}