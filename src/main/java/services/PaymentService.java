package services;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import Storage.Storage;
import dao.PaymentDAO;
import dao.SubscriptionDAO;
import entity.Payment;
import entity.PaymentStatus;
import entity.SubscriptionWithCommitment;

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

    public static void modifyPayment(int paymentId, String paymentDateText, String statusText)
    {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yy");
        format.setLenient(false);

        try {
            Date paymentDate = parseDate(format, paymentDateText);
            PaymentStatus status = parseStatus(statusText);

            if (PaymentDAO.updatePayment(paymentId, paymentDate, status)) {
                System.out.println("Payment successfully modified.");
            } else {
                System.out.println("Payment not found.");
            }
        } catch (Exception exception) {
            System.out.println("Invalid payment date or status.");
            System.out.println("Use MM/dd/yy and Paid, Unpaid, or Late.");
        }
    }

    public static void deletePayment(int paymentId)
    {
        if (PaymentDAO.deletePayment(paymentId)) {
            System.out.println("Payment successfully deleted.");
        } else {
            System.out.println("Payment not found.");
        }
    }

    public static String getMissedPaymentsWithTotalUnpaidAmount()
    {
        double totalUnpaidAmount = 0;
        StringBuilder report = new StringBuilder();
        report.append("Missed payments for subscriptions with commitment:\n");

        boolean hasMissedPayments = false;

        for (SubscriptionWithCommitment subscription : Storage.getStorageWith().values()) {
            List<Payment> payments = PaymentDAO.findBySubscription(subscription.getServiceName());
            boolean subscriptionHasMissedPayment = false;

            for (Payment payment : payments) {
                if (payment.getPaymentType() == PaymentStatus.Unpaid || payment.getPaymentType() == PaymentStatus.Late) {
                    if (!subscriptionHasMissedPayment) {
                        report.append("- ").append(subscription.getServiceName()).append("\n");
                        subscriptionHasMissedPayment = true;
                    }
                    report.append("  * Payment ID ").append(payment.getPaymentId())
                          .append(" is ").append(payment.getPaymentType()).append("\n");
                    totalUnpaidAmount += parseMonthlyAmount(subscription.getMonthlyAmount());
                    hasMissedPayments = true;
                }
            }
        }

        if (!hasMissedPayments) {
            return "No missed payments found for subscriptions with commitment.";
        }

        report.append("Total unpaid amount: ")
              .append(String.format("%.0f", totalUnpaidAmount)).append("DH");

        return report.toString();
    }

    public static String displayAmountPaidForSubscription(String serviceName)
    {
        if (SubscriptionDAO.updateSubscriptionWith(serviceName) == null
                && SubscriptionDAO.updateSubscriptionWithout(serviceName) == null) {
            return "Subscription not found.";
        }

        String monthlyAmountText = null;
        if (SubscriptionDAO.updateSubscriptionWith(serviceName) != null) {
            monthlyAmountText = SubscriptionDAO.updateSubscriptionWith(serviceName).getMonthlyAmount();
        } else {
            monthlyAmountText = SubscriptionDAO.updateSubscriptionWithout(serviceName).getMonthlyAmount();
        }

        double monthlyAmount = parseMonthlyAmount(monthlyAmountText);
        int paidPaymentCount = 0;

        for (Payment payment : PaymentDAO.findBySubscription(serviceName)) {
            if (payment.getPaymentType() == PaymentStatus.Paid || payment.getPaymentType() == PaymentStatus.Late) {
                paidPaymentCount++;
            }
        }

        double totalPaidAmount = paidPaymentCount * monthlyAmount;
        return "Amount paid for " + serviceName + ": " + String.format("%.0f", totalPaidAmount) + "DH";
    }

    private static double parseMonthlyAmount(String monthlyAmount)
    {
        try {
            return Double.parseDouble(monthlyAmount.replaceAll("[^0-9.]", ""));
        } catch (NumberFormatException exception) {
            return 0;
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

    private static PaymentStatus parseStatus(String statusText) throws Exception
    {
        if (statusText.equalsIgnoreCase("Paid")) {
            return PaymentStatus.Paid;
        }
        if (statusText.equalsIgnoreCase("Unpaid")) {
            return PaymentStatus.Unpaid;
        }
        if (statusText.equalsIgnoreCase("Late")) {
            return PaymentStatus.Late;
        }

        throw new Exception("Invalid status");
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
