package in.webinex.orders;

import in.webinex.notification.NotificationService;
import in.webinex.notification.SmsNotification;
import in.webinex.payement.CreditCard;
import in.webinex.payement.PaymentService;

public class OrderService {
    PaymentService paymentService ;
    NotificationService notificationService ;
    public OrderService(PaymentService paymentService, NotificationService notificationService){
       this.paymentService = paymentService;
       this.notificationService = notificationService;
    }

    public void placeOrder(){
        paymentService.payment();
        System.out.println("Order Placed");
        notificationService.sendNotification();
    }
}
