package presentation;

import services.SubscriptionService;

public class SubscriptionList {
    public static java.util.Scanner scan = Menu.scan;
    
    public static void show()
    {
        int choice;
        boolean pick = false;

        

        while(!pick){
            System.out.println("****************************** View The List of Subscription ******************************");
            System.out.println("1. Subscriptions With Commitment");
            System.out.println("2. Subscriptions Without Commitment");
            System.out.println("0. Exit");
            System.out.println("*****************************************************************************************");

            choice = scan.nextInt();

            switch (choice) {
                case 0:
                    pick = true;
                    break;
                case 1:
                    showSubsWith();
                    break;
                case 2:
                    showSubsWithout();
                    break;
                default:
                    System.out.println("Invalid Choice. Please Try Again");
            }
        }
    }

    public static void showSubsWith()
    {
            System.out.println("****************************** List of Subscription ******************************");
            System.out.println("");
            SubscriptionService.listWith();
            System.out.println("");
            System.out.println("*****************************************************************************************");
    }

    public static void showSubsWithout()
    {
            System.out.println("****************************** List of Subscription ******************************");
            System.out.println("");
            SubscriptionService.listWithout();
            System.out.println("");
            System.out.println("*****************************************************************************************");
    }
}
