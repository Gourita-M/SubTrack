package presentation;

import java.util.Scanner;

public class Menu {

    public static Scanner scan = new Scanner(System.in);

    public static void start()
    {
        int choice;
        boolean picked = false;

        

        while(!picked){
            System.out.println("********************************** Welcome To SubTrack **********************************");
            System.out.println("1. Create subscriptions (with/without commitment)"); // Done
            System.out.println("2. Modify or delete a subscription"); // kinda Done . Be9a liya ghi modify idk what to modify
            System.out.println("3. View the list of subscriptions"); // Done
            System.out.println("4. Display payments for a subscription"); 
            System.out.println("5. Record a payment");
            System.out.println("6. Modify or delete a payment");
            System.out.println("7. View missed payments with the total unpaid amount (for subscriptions with commitment)");
            System.out.println("8. Display the amount paid for a subscription");
            System.out.println("9. Display the 5 most recent payments");
            System.out.println("10. Generate financial reports (monthly, annual, unpaid)");
            System.out.println("0. Exit");
            System.out.println("*****************************************************************************************");

            choice = scan.nextInt();
            switch (choice) {
                case 0:
                    System.err.println("Come Back Soon");
                    picked = true;
                    break;
                case 1:
                    SubscriptionMenu.show();
                    break;
                case 2:
                    SubscriptionModify.show();
                    break;
                case 3:
                    SubscriptionList.show();
                    break;
                case 4:
                    scan.nextLine();
                    System.out.println("Enter Service Name: ");
                    String serviceName = scan.nextLine();
                    services.PaymentService.displayPaymentsForSubscription(serviceName);
                    break;
                case 5:
                    scan.nextLine();
                    System.out.println("Enter Service Name: ");
                    String paymentServiceName = scan.nextLine();
                    System.out.println("Enter Payment Date (mm/dd/yy): ");
                    String paymentDate = scan.nextLine();
                    services.PaymentService.recordPayment(paymentServiceName, paymentDate);
                    break;
                case 6:
                    
                    break;
                case 7:
                    
                    break;
                case 8:
                    
                    break;
                case 9:
                    
                    break;
                case 10:
                    
                    break;

                default:
                    System.err.println("Invalid Choice. Please Try Again");
            }
        }

    }
}