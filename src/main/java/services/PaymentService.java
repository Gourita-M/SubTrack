package services;

import java.util.List;

import dao.PaymentDAO;
import dao.SubscriptionDAO;
import entity.Payment;

public class PaymentService {

    public static void displayPaymentsForSubscription(String serviceName)
    {
        if (SubscriptionDAO.updateSubscriptionWith(serviceName) == null
                && SubscriptionDAO.updateSubscriptionWithout(serviceName) == null) {
            System.out.println("Subscription not found.");
            return;
        }

        List<Payment> payments = PaymentDAO.findBySubscription(serviceName);

        if (payments.isEmpty()) {
            System.out.println("No payments found for this subscription.");
        } else {
            for (Payment payment : payments) {
                System.out.println(payment);
            }
        }
    }
    
    public void paymentHistory()
    {

    }
    public void modifyPayment()
    {

    }
    public void deletePayment()
    {

    }
    public void upaidPaymentDetector()
    {

    }
    
}
