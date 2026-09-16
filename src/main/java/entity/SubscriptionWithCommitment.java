package entity;

import java.util.Date;

public class SubscriptionWithCommitment extends Subscription {
    private long commitmentDurationMonths;
    
    public SubscriptionWithCommitment(String serviceName, String monthlyAmount, Date startDate, Date endDate, Status status, long commitmentDurationMonths)
    {
        super(serviceName, monthlyAmount, startDate, endDate, status);
        this.commitmentDurationMonths = commitmentDurationMonths;
    }

    public void setCommitmentDurationMonths(int commitmentDurationMonths)
    {
        this.commitmentDurationMonths = commitmentDurationMonths;
    }
    public long getCommitmentDurationMonths()
    {
        return commitmentDurationMonths;
    }

    @Override
    public String toString()
    {
        return getId() + "- Service Name: " + getServiceName() + ". Amount: " + getMonthlyAmount() + "DH From: "
                    + getStartDate() + " To: " + getEndDate() + " Commitment Time: " + getCommitmentDurationMonths();
    }
}
