package entity;

import java.util.Date;

public class SubsctiptionWithCommitment extends Subscription {
    private int commitmentDurationMonths;
    
    public SubsctiptionWithCommitment(String serviceName, String monthlyAmount, Date startDate, Date endDate, Status status, int commitmentDurationMonths)
    {
        super(serviceName, monthlyAmount, startDate, endDate, status);
        this.commitmentDurationMonths = commitmentDurationMonths;
    }

    public void setCommitmentDurationMonths(int commitmentDurationMonths)
    {
        this.commitmentDurationMonths = commitmentDurationMonths;
    }
    public int getCommitmentDurationMonths()
    {
        return commitmentDurationMonths;
    }
}
