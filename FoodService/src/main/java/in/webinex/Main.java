package in.webinex;

import in.webinex.notification.EmailNotification;
import in.webinex.notification.NotificationService;
import in.webinex.notification.SmsNotification;
import in.webinex.orders.OrderService;
import in.webinex.payement.CreditCard;
import in.webinex.payement.DebitCard;
import in.webinex.payement.PaymentService;

/*trying to write code of food service*/
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() {
    /*Feature right i will implement
    * 1.placeOrder
    * 2.paymentDone
    * 3.notificationSent*/

        /*as of now we have not implemented any dependency injection as
        * 1. order service depends on notification and payment */
        PaymentService paymentService = new DebitCard();
        NotificationService notificationService = new SmsNotification();
        OrderService orderService = new OrderService(paymentService,notificationService);
        orderService.placeOrder();
    }
}
