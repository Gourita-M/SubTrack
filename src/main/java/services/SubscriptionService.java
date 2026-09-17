package services;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import dao.PaymentDAO;
import dao.SubscriptionDAO;
import entity.PaymentStatus;
import entity.Status;

public class SubscriptionService {
    
    public static void createWithCommitment(String serviceName, String monthlyAmount, String startDat, String endDat)
    {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yy");
        format.setLenient(false);

        try{
            Date startDate = parseDate(format, startDat);
            Date endDate = parseDate(format, endDat);

            if (!endDate.after(startDate)) {
                System.out.println("End date must be after start date.");
                return;
            }

            Calendar startCalendar = Calendar.getInstance();
            Calendar endCalendar = Calendar.getInstance();
            startCalendar.setTime(startDate);
            endCalendar.setTime(endDate);

            long commitmentDurationMonths = (endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR)) * 12L;
            commitmentDurationMonths += endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);

            SubscriptionDAO subscriptionDAO = new SubscriptionDAO();
            subscriptionDAO.creatSubscriptionWith(serviceName, monthlyAmount, startDate, endDate, Status.Active, commitmentDurationMonths);

            PaymentDAO.createPayment(serviceName, endDate, null, PaymentStatus.Unpaid);

            }catch(Exception e){
                System.out.println("Invalid date format. Please use MM/dd/yy.");
            }
        
    }

    public static void createWithoutCommitment(String serviceName, String monthlyAmount, String startDat, String endDat)
    {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yy");
        format.setLenient(false);

        try{
            Date startDate = parseDate(format, startDat);
            Date endDate = parseDate(format, endDat);

            if (!endDate.after(startDate)) {
                System.out.println("End date must be after start date.");
                return;
            }

            SubscriptionDAO subscriptionDAO = new SubscriptionDAO();
            subscriptionDAO.creatSubscriptionWithout(serviceName, monthlyAmount, startDate, endDate, Status.Active);

            }catch(Exception e){
                System.out.println("Invalid date format. Please use MM/dd/yy.");
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

    public static void modification(String serviceName, String monthlyAmount)
    {
        if (SubscriptionDAO.updateSubscriptionWith(serviceName) != null) {
            SubscriptionDAO.updateSubscriptionWith(serviceName).setMonthlyAmount(monthlyAmount);
            System.out.println("Subscription successfully modified.");
        } else if (SubscriptionDAO.updateSubscriptionWithout(serviceName) != null) {
            SubscriptionDAO.updateSubscriptionWithout(serviceName).setMonthlyAmount(monthlyAmount);
            System.out.println("Subscription successfully modified.");
        } else {
            System.out.println("Service is Not Found");
        }
    }

    public static void delete(String ServiceName)
    {
        if(SubscriptionDAO.deleteSubscription(ServiceName)){
            System.err.println("Service is Deleted");
        }else{
            System.out.println("Service is Not Found");
        }
    }

    public void finished()
    {

    }

    public static void listWith()
    {
        SubscriptionDAO.showAllSubsWith();
    }

    public static void listWithout()
    {
        SubscriptionDAO.showAllSubsWithout();
    }
}
