package services;

import java.text.SimpleDateFormat;
import java.util.Date;
import entity.SubsctiptionWithCommitment;

public class SubscriptionService {
    
    public static void createWithCommitment(String serviceName, String monthlyAmount, String startDat, String endDat)
    {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yy");

        try{
            Date startDate = format.parse(startDat);
            System.err.println("Enter Your Service End Date (mm/dd/yy): ");
            Date endDate = format.parse(endDat);

            SubsctiptionWithCommitment subscribe = new SubsctiptionWithCommitment(serviceName, monthlyAmount, startDate, endDate, Status.Active, 5);

            } catch(Exception e){

                System.out.println("Invalid Date Formate");

            }

        

    }
    public void createWithoutCommitment()
    {

    }
    public void modification()
    {

    }
    public void delete()
    {

    }
    public void finished()
    {

    }
}
