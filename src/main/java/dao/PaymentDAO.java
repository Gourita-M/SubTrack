package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Storage.Storage;
import entity.Payment;
import entity.PaymentStatus;

public class PaymentDAO {

    public static void createPayment(String serviceName, Date dueDate, Date paymentDate, PaymentStatus status){
        if(Storage.getStorageWith().containsKey(serviceName)){
            int subscriptionId = Storage.getStorageWith().get(serviceName).getId();
            //int subscriptionId, Date dueDate, Date paymentDate, Status paymentType

            Payment payment = new Payment(subscriptionId, dueDate, paymentDate, status);
            Storage.setPayments(payment);

        }else if(Storage.getStorageWithout().containsKey(serviceName)){
            int subscriptionId = Storage.getStorageWithout().get(serviceName).getId();
            Payment payment = new Payment(subscriptionId, dueDate, paymentDate, status);
            Storage.setPayments(payment);
        }
    }   
    public void findById(int id)
    {

    }
    public static List<Payment> findBySubscription(String serviceName)
    {
        int subscriptionId = -1;

        if (Storage.getStorageWith().containsKey(serviceName)) {
            subscriptionId = Storage.getStorageWith().get(serviceName).getId();
        } else if (Storage.getStorageWithout().containsKey(serviceName)) {
            subscriptionId = Storage.getStorageWithout().get(serviceName).getId();
        }

        List<Payment> subscriptionPayments = new ArrayList<>();

        for (Payment payment : Storage.getPayments()) {
            if (payment.getSubscriptionId() == subscriptionId) {
                subscriptionPayments.add(payment);
            }
        }

        return subscriptionPayments;
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
