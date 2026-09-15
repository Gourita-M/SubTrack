package presentation;

import java.util.Scanner;

public class SubscriptionMenu {
    public static Scanner scan = new Scanner(System.in);
    
    public static void show()
    {
        int choice;
        boolean picked = false;

        System.out.println("****************************** Welcome To Subscription Menu ******************************");
        System.out.println("1. Create subscriptions With Commitment");
        System.out.println("2. Create subscriptions Without Commitment");
        System.out.println("0. Leave");
        System.out.println("*****************************************************************************************");

        while(!picked){
            choice = scan.nextInt();

            switch (choice) {
                case 0:
                    picked = true;
                    break;
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                default:
                    System.out.println("Invalid Choice. Please Try Again");
            }
        }
    }
}
