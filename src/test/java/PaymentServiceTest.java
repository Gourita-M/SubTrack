import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Storage.Storage;
import entity.Payment;
import entity.PaymentStatus;
import entity.Status;
import entity.SubscriptionWithCommitment;
import services.PaymentService;

public class PaymentServiceTest {

    @BeforeEach
    public void resetStorage() {
        Storage.storageWith.clear();
        Storage.storageWithout.clear();
        Storage.payments.clear();
    }

    @Test
    public void shouldReportMissedPaymentsAndTotalUnpaidAmountForCommittedSubscriptions() throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yy", Locale.US);
        Date start = format.parse("01/01/24");
        Date end = format.parse("12/31/24");

        Storage.setStoragewith("Netflix", new SubscriptionWithCommitment("Netflix", "20", start, end, Status.Active, 12));
        Storage.setStoragewith("Spotify", new SubscriptionWithCommitment("Spotify", "10", start, end, Status.Active, 6));

        Storage.setPayments(new Payment(Storage.getStorageWith().get("Netflix").getId(), start, null, PaymentStatus.Unpaid));
        Storage.setPayments(new Payment(Storage.getStorageWith().get("Netflix").getId(), end, null, PaymentStatus.Late));
        Storage.setPayments(new Payment(Storage.getStorageWith().get("Spotify").getId(), start, null, PaymentStatus.Unpaid));

        String report = PaymentService.getMissedPaymentsWithTotalUnpaidAmount();

        assertTrue(report.contains("Netflix"));
        assertTrue(report.contains("Spotify"));
        assertTrue(report.contains("Total unpaid amount: 30DH"));
        assertTrue(report.contains("Missed payments"));
    }
}
