package dao;

import java.util.Date;

import Storage.Storage;
import entity.Status;
import entity.SubscriptionWithoutCommitment;
import entity.SubsctiptionWithCommitment;

public class SubscriptionDAO {

    public void creatSubscriptionWith(String serviceName, String monthlyAmount, Date startDate, Date endDate, Status status, long commitmentDurationMonths)
    {
        SubsctiptionWithCommitment subsctiptionWithCommitment = new SubsctiptionWithCommitment(serviceName, monthlyAmount, startDate, endDate, status, commitmentDurationMonths);
        if(Storage.getStorageWith().containsKey(serviceName)){
            System.out.println("You Already Get This Service");
        }else{
        Storage.setStoragewith(serviceName, subsctiptionWithCommitment);
        }
    }

    public void creatSubscriptionWithout(String serviceName, String monthlyAmount, Date startDate, Date endDate, Status status)
    {
        SubscriptionWithoutCommitment subscriptionWithoutCommitment = new SubscriptionWithoutCommitment(serviceName, monthlyAmount, startDate, endDate, status);
        if(Storage.getStorageWith().containsKey(serviceName)){
            System.out.println("You Already Get This Service");
        }else{
        Storage.setStoragewithout(serviceName, subscriptionWithoutCommitment);
        }
    }

    public static void showAllSubsWith()
    {
        Storage.getStorageWith().values().stream()
        .forEach(m -> System.out.println(m.toString()));
    }

    public static void showAllSubsWithout()
    {
        Storage.getStorageWithout().values().stream()
        .forEach(m -> System.out.println(m.toString()));
    }

    public void findById(int id)
    {

    }
    public void updateSubscription()
    {

    }
    public void deleteSubscription()
    {

    }
    public void findActiveSubscriptions()
    {

    }
    public void findByType()
    {
        
    }
}
