package in.webinex.notification;

public class EmailNotification implements NotificationService {
    @Override
    public void sendNotification() {
        System.out.println("Email notification Sent");
    }
}
