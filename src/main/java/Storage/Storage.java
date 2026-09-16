package Storage;

import java.util.HashMap;

import entity.SubscriptionWithCommitment;
import entity.SubscriptionWithoutCommitment;

public class Storage {

    public static HashMap<String, SubscriptionWithoutCommitment> storageWithout = new HashMap<>();
    public static HashMap<String, SubscriptionWithCommitment> storageWith = new HashMap<>();
    
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
}
