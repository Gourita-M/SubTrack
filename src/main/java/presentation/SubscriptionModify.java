package presentation;

import java.util.Scanner;

import services.SubscriptionService;

public class SubscriptionModify {

    public static Scanner scan = new Scanner(System.in);
    
    public static void show()
    {
        int choice;
        boolean pick = false;

        

        while(!pick){
            System.out.println("**************************** Modify Or Delete a Subscription ****************************");
            System.out.println("1. Modify a Subscription");
            System.out.println("2. Delete a Subscription");
            System.out.println("0. Exit");
            System.out.println("*****************************************************************************************");

            choice = scan.nextInt();

            switch (choice) {
                case 0:
                    pick = true;
                    break;
                case 1:
                    modify();
                    break;
                case 2:
                    delete();
                    break;
                default:
                    System.out.println("Invalid Choice. Please Try Again");
            }
        }
        
    }

    public static void modify()
    {
        scan.nextLine();
        System.out.println("Enter Service Name: ");
        String serviceName = scan.nextLine();
        
        // if(!SubscriptionDAO.findByServiceName(serviceName)){
        //     System.out.println("Service is Not Found");   
        // }else{

        //     SubscriptionService.modification();

        // }
    }

    public static void delete()
    {
        scan.nextLine();
        System.out.println("Enter Service Name: ");
        String serviceName = scan.nextLine();

        SubscriptionService.delete(serviceName);


    }

}
