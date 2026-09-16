package Storage;

import java.util.HashMap;

import entity.SubscriptionWithoutCommitment;
import entity.SubsctiptionWithCommitment;

public class Storage {

    public static HashMap<String, SubscriptionWithoutCommitment> storageWithout = new HashMap<>();
    public static HashMap<String, SubsctiptionWithCommitment> storageWith = new HashMap<>();
    
    public static void setStoragewith(String key, SubsctiptionWithCommitment with)
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
    public static HashMap<String, SubsctiptionWithCommitment> getStorageWith()
    {
        return storageWith;
    }
}
