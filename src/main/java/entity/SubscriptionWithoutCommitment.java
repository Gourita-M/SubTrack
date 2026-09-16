package entity;

import java.util.Date;

public class SubscriptionWithoutCommitment extends Subscription{
    
    public SubscriptionWithoutCommitment(String serviceName, String monthlyAmount, Date startDate, Date endDate, Status status)
    {
        super(serviceName, monthlyAmount, startDate, endDate, status);
    }
}
