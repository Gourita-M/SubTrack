package entity;

import java.util.Date;

public class Payment{
    
    private String paymentId;
    private int subscriptionId;
    private Date dueDate;
    private Date paymentDate;
    private Status paymentType;

    public Payment(String paymentId, int subscriptionId, Date dueDate, Date paymentDate, Status paymentType)
    {
        this.paymentId = paymentId;
        this.subscriptionId = subscriptionId;
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
        this.paymentType = paymentType;
    }

    public void setPaymentId(String paymentId)
    {
        this.paymentId = paymentId;
    }
    public void setSubscriptionId(int subscriptionId)
    {
        this.subscriptionId = subscriptionId;
    }
    public void setDueDate(Date dueDate)
    {
        this.dueDate = dueDate;
    }
    public void setPaymentDate(Date paymentDate)
    {
        this.paymentDate = paymentDate;
    }
    public void setPaymentType(Status paymentType)
    {
        this.paymentType = paymentType;
    }

    public enum Status {
        Paid,
        Unpaid,
        Late
    }
}
