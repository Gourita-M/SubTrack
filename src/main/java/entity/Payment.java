package entity;

import java.util.Date;

public class Payment{
    public static int counter = 0;
    private int paymentId;
    private int subscriptionId;
    private Date dueDate;
    private Date paymentDate;
    private PaymentStatus paymentType;

    public Payment(int subscriptionId, Date dueDate, Date paymentDate, PaymentStatus paymentType)
    {
        this.paymentId = counter++;
        this.subscriptionId = subscriptionId;
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
        this.paymentType = paymentType;
    }

    public void setPaymentId(int paymentId)
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
    public void setPaymentType(PaymentStatus paymentType)
    {
        this.paymentType = paymentType;
    }
}
