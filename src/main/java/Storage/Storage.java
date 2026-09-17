package Storage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import entity.Payment;
import entity.SubscriptionWithCommitment;
import entity.SubscriptionWithoutCommitment;

public class Storage {

    public static HashMap<String, SubscriptionWithoutCommitment> storageWithout = new HashMap<>();
    public static HashMap<String, SubscriptionWithCommitment> storageWith = new HashMap<>();
    public static List<Payment> payments = new ArrayList<>();
    
    public static void setStoragewith(String key, SubscriptionWithCommitment with)
    {
        storageWith.put(key, with);
    }
    public static void setStoragewithout(String key, SubscriptionWithoutCommitment without)
    {
        storageWithout.put(key, without);
    }
    public static HashMap<String, SubscriptionWithoutCommitment> getStorageWithout()
    {
        return storageWithout;
    }
    public static HashMap<String, SubscriptionWithCommitment> getStorageWith()
    {
        return storageWith;
    }

    public static void setPayments(Payment payment)
    {
        payments.add(payment);
    }
    public static List<Payment> getPayments()
    {
        return payments;
    }
}
