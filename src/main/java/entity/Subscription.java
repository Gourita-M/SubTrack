package entity;

import java.util.Date;

public abstract class Subscription {
    private String id;
    private String serviceName;
    private String monthlyAmount;
    private Date startDate;
    private Date endDate;
    private Status status;

    public Subscription(String serviceName, String monthlyAmount, Date startDate, Date endDate, Status status)
    {
        this.serviceName = serviceName;
        this.monthlyAmount = monthlyAmount;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public enum Status {
        Active,
        Suspended,
        Terminated
    }

    public void setServiceName(String serviceName)
    {
        this.serviceName = serviceName;
    }
    public void setMonthlyAmount(String monthlyAmount)
    {
        this.monthlyAmount = monthlyAmount;
    }
    public void setStartDate(Date startDate)
    {
        this.startDate = startDate;
    }
    public void setEndDate(Date endDate)
    {
        this.endDate = endDate;
    }
    public void setStatus(Status status)
    {
        this.status = status;
    }

    public String getServiceName()
    {
        return serviceName;
    }
    public String getMonthlyAmount()
    {
        return monthlyAmount;
    }
    public Date getStartDate()
    {
        return startDate;
    }
    public Date getEndDate()
    {
        return endDate;
    }
    public Status getStatus()
    {
        return status;
    }
}
