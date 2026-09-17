package dao;

import java.util.Date;

import Storage.Storage;
import entity.Payment;
import entity.PaymentStatus;

public class PaymentDAO {

    public static void createPayment(String serviceName, Date dueDate, Date paymentDate, PaymentStatus status){
        if(Storage.getStorageWith().containsKey(serviceName)){
            int subscriptionId = Storage.getStorageWith().get(serviceName).getId();
            //int subscriptionId, Date dueDate, Date paymentDate, Status paymentType

            Payment payment = new Payment(subscriptionId, dueDate, paymentDate, status);

        }else if(Storage.getStorageWithout().containsKey(serviceName)){
            int subscriptionId = Storage.getStorageWithout().get(serviceName).getId();
        }
    }   
    public void findById(int id)
    {

    }
    public void findBySubscription()
    {
        
    }
    public void findAll()
    {

    }
    public void update()
    {

    }
    public void delete()
    {

    }
    public void findUnpaidBySubscription()
    {

    }
    public void findLastPayments()
    {
        
    }
}
