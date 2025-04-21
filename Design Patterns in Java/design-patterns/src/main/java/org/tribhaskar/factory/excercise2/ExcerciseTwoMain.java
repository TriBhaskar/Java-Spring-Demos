package org.tribhaskar.factory.excercise2;

public class ExcerciseTwoMain {
    public static void main(String[] args) {
        NotificationFactory notificationFactory = new NotificationFactory();

        Notification smsNotification = notificationFactory.createNotification("SMS");
        smsNotification.notifyUser();

        Notification emailNotification = notificationFactory.createNotification("EMAIL");
        emailNotification.notifyUser();

        Notification pushNotification = notificationFactory.createNotification("PUSH");
        pushNotification.notifyUser();
    }
}
