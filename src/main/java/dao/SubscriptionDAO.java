package dao;

import java.util.Date;

import Storage.Storage;
import entity.Status;
import entity.SubscriptionWithCommitment;
import entity.SubscriptionWithoutCommitment;

public class SubscriptionDAO {

    public void creatSubscriptionWith(String serviceName, String monthlyAmount, Date startDate, Date endDate, Status status, long commitmentDurationMonths)
    {
        SubscriptionWithCommitment subsctiptionWithCommitment = new SubscriptionWithCommitment(serviceName, monthlyAmount, startDate, endDate, status, commitmentDurationMonths);
        if(Storage.getStorageWith().containsKey(serviceName)
            || Storage.getStorageWithout().containsKey(serviceName)){
            System.out.println("You Already Get This Service");
        }else{
        Storage.setStoragewith(serviceName, subsctiptionWithCommitment);
        }
    }

    public void creatSubscriptionWithout(String serviceName, String monthlyAmount, Date startDate, Date endDate, Status status)
    {
        SubscriptionWithoutCommitment subscriptionWithoutCommitment = new SubscriptionWithoutCommitment(serviceName, monthlyAmount, startDate, endDate, status);
        if(Storage.getStorageWith().containsKey(serviceName)
            || Storage.getStorageWithout().containsKey(serviceName)){
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

    public void findByServiceName(int id)
    {
        
    }

    public static SubscriptionWithCommitment updateSubscriptionWith(String ServiceName)
    {
        if(Storage.getStorageWith().containsKey(ServiceName)){
            
            return Storage.getStorageWith().get(ServiceName);
        }

        return null;
    }

    public static SubscriptionWithoutCommitment updateSubscriptionWithout(String ServiceName)
    {
        if(Storage.getStorageWithout().containsKey(ServiceName)){
            
            return Storage.getStorageWithout().get(ServiceName);
        }
        
        return null;
    }

    public static boolean deleteSubscription(String ServiceName)
    {
        if(Storage.getStorageWith().containsKey(ServiceName)){
            
            Storage.getStorageWith().remove(ServiceName);
            return true;
        }

        if(Storage.getStorageWithout().containsKey(ServiceName)){
            
            Storage.getStorageWithout().remove(ServiceName);
            return true;
        }

        return false;
    }

    public void findActiveSubscriptions()
    {

    }

    public void findByType()
    {

    }
    
}
