package presentation;

import java.util.Scanner;

import services.SubscriptionService;

public class SubscriptionMenu {
    public static Scanner scan = new Scanner(System.in);
    
    public static void show()
    {
        int choice;
        boolean pick = false;

        

        while(!pick){
            System.out.println("****************************** Welcome To Subscription Menu ******************************");
            System.out.println("1. Create subscriptions With Commitment");
            System.out.println("2. Create subscriptions Without Commitment");
            System.out.println("0. Exit");
            System.out.println("*****************************************************************************************");

            choice = scan.nextInt();

            switch (choice) {
                case 0:
                    pick = true;
                    break;
                case 1:
                    withCommitment();
                    break;
                case 2:
                    
                    break;
                default:
                    System.out.println("Invalid Choice. Please Try Again");
            }
        }
        
    }
    public static void withCommitment()
    {   
        
            scan.nextLine(); //bash ne7ayad LeftOvers
        
            System.out.println("****************************** Subscription With Commitment ******************************");
            System.err.println("Enter Your Service Name");
            String serviceName = scan.nextLine();
            System.err.println("Enter Your Monthly Payment Amount");
            String monthlyAmount = scan.nextLine();
            System.err.println("Enter Your Service Start Date (mm/dd/yy): ");
            String startDate = scan.nextLine();
            System.err.println("Enter Your Service End Date (mm/dd/yy): ");
            String endDate = scan.nextLine();
            
            SubscriptionService.createWithCommitment(serviceName, monthlyAmount, startDate, endDate);
    }
}
