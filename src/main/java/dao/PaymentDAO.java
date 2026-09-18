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

    public static boolean recordPayment(String serviceName, Date paymentDate)
    {
        List<Payment> subscriptionPayments = findBySubscription(serviceName);

        for (Payment payment : subscriptionPayments) {
            if (payment.getPaymentType() == PaymentStatus.Unpaid
                    || payment.getPaymentType() == PaymentStatus.Late) {
                payment.setPaymentDate(paymentDate);
                payment.setPaymentType(PaymentStatus.Paid);
                return true;
            }
        }

        if (Storage.getStorageWith().containsKey(serviceName)
                || Storage.getStorageWithout().containsKey(serviceName)) {
            createPayment(serviceName, paymentDate, paymentDate, PaymentStatus.Paid);
            return true;
        }

        return false;
    }

    public static Payment findById(int paymentId)
    {
        for (Payment payment : Storage.getPayments()) {
            if (payment.getPaymentId() == paymentId) {
                return payment;
            }
        }

        return null;
    }

    public static boolean deletePayment(int paymentId)
    {
        Payment payment = findById(paymentId);

        if (payment != null) {
            Storage.getPayments().remove(payment);
            return true;
        }

        return false;
    }

    public static boolean updatePayment(int paymentId, Date paymentDate, PaymentStatus status)
    {
        Payment payment = findById(paymentId);

        if (payment != null) {
            payment.setPaymentDate(paymentDate);
            payment.setPaymentType(status);
            return true;
        }

        return false;
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
