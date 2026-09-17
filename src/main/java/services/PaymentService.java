package services;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import dao.PaymentDAO;
import dao.SubscriptionDAO;
import entity.Payment;

public class PaymentService {

    public static void recordPayment(String serviceName, String paymentDateText)
    {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yy");
        format.setLenient(false);

        try {
            Date paymentDate = parseDate(format, paymentDateText);

            if (PaymentDAO.recordPayment(serviceName, paymentDate)) {
                System.out.println("Payment successfully recorded.");
            } else {
                System.out.println("Subscription not found.");
            }
        } catch (Exception exception) {
            System.out.println("Invalid date format. Please use MM/dd/yy.");
        }
    }

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

    private static Date parseDate(SimpleDateFormat format, String dateText) throws Exception
    {
        ParsePosition position = new ParsePosition(0);
        Date date = format.parse(dateText, position);

        if (date == null || position.getIndex() != dateText.length()) {
            throw new Exception("Invalid date");
        }

        return date;
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
