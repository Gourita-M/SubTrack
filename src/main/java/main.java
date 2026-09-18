import java.text.SimpleDateFormat;
import java.util.Locale;

import Storage.Storage;
import dao.PaymentDAO;
import dao.SubscriptionDAO;
import entity.PaymentStatus;
import entity.Status;
import presentation.Menu;

public class main {
    public static void main(String[] args) {
        seedDemoData();
        Menu.start();
    }

    private static void seedDemoData() {
        Storage.storageWith.clear();
        Storage.storageWithout.clear();
        Storage.payments.clear();

        try {
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yy", Locale.US);

            SubscriptionDAO subscriptionDAO = new SubscriptionDAO();

            subscriptionDAO.creatSubscriptionWith(
                    "Netflix",
                    "20DH",
                    format.parse("01/01/24"),
                    format.parse("12/31/24"),
                    Status.Active,
                    12
            );

            subscriptionDAO.creatSubscriptionWith(
                    "Spotify",
                    "15DH",
                    format.parse("01/01/24"),
                    format.parse("12/31/24"),
                    Status.Active,
                    6
            );

            subscriptionDAO.creatSubscriptionWithout(
                    "Gym",
                    "30DH",
                    format.parse("01/15/24"),
                    format.parse("12/15/24"),
                    Status.Active
            );

            PaymentDAO.createPayment("Netflix", format.parse("01/15/24"), format.parse("01/14/24"), PaymentStatus.Paid);
            PaymentDAO.createPayment("Netflix", format.parse("02/15/24"), null, PaymentStatus.Unpaid);
            PaymentDAO.createPayment("Netflix", format.parse("03/15/24"), null, PaymentStatus.Late);

            PaymentDAO.createPayment("Spotify", format.parse("01/20/24"), format.parse("01/19/24"), PaymentStatus.Paid);
            PaymentDAO.createPayment("Spotify", format.parse("02/20/24"), null, PaymentStatus.Unpaid);

            PaymentDAO.createPayment("Gym", format.parse("01/20/24"), format.parse("01/18/24"), PaymentStatus.Paid);
            PaymentDAO.createPayment("Gym", format.parse("02/20/24"), null, PaymentStatus.Unpaid);

        } catch (Exception exception) {
            System.err.println("Unable to initialize demo data.");
        }
    }
}
