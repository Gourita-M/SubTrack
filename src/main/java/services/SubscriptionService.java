package services;

import java.text.SimpleDateFormat;
import java.util.Date;

import dao.SubscriptionDAO;
import entity.Status;

public class SubscriptionService {
    
    public static void createWithCommitment(String serviceName, String monthlyAmount, String startDat, String endDat)
    {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yy");

        try{
            Date startDate = format.parse(startDat);
            System.err.println("Enter Your Service End Date (mm/dd/yy): ");
            Date endDate = format.parse(endDat);

            long diffrence = endDate.getTime() - startDate.getTime();
            long days = diffrence / (1000 * 60 * 60 * 24);

            SubscriptionDAO subscriptionDAO = new SubscriptionDAO();
            subscriptionDAO.creatSubscriptionWith(serviceName, monthlyAmount, startDate, endDate, Status.Active, days);

            }catch(Exception e){
                System.out.println("Invalid Date Formate");
            }

    }

    public static void createWithoutCommitment(String serviceName, String monthlyAmount, String startDat, String endDat)
    {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yy");

        try{
            Date startDate = format.parse(startDat);
            System.err.println("Enter Your Service End Date (mm/dd/yy): ");
            Date endDate = format.parse(endDat);

            SubscriptionDAO subscriptionDAO = new SubscriptionDAO();
            subscriptionDAO.creatSubscriptionWithout(serviceName, monthlyAmount, startDate, endDate, Status.Active);

            }catch(Exception e){
                System.out.println("Invalid Date Formate");
            }
    }

    public static void modification()
    {
        
    }

    public static void delete(String ServiceName)
    {
        if(SubscriptionDAO.deleteSubscription(ServiceName)){
            System.err.println("Service is Deleted");
        }else{
            System.out.println("Service is Not Found");
        }
    }

    public void finished()
    {

    }

    public static void listWith()
    {
        SubscriptionDAO.showAllSubsWith();
    }

    public static void listWithout()
    {
        SubscriptionDAO.showAllSubsWithout();
    }
}
