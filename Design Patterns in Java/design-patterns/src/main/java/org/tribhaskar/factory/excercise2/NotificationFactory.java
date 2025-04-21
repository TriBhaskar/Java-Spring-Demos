package org.tribhaskar.factory.excercise2;

public class NotificationFactory {
    public Notification createNotification(String notificationType) {
        if (notificationType == null) return null;
        switch (notificationType.toUpperCase()) {
            case "EMAIL":
                return new EmailNotification();
            case "SMS":
                return new SMSNotification();
            case "PUSH":
                return new PushNotification();
            default:
                throw new IllegalArgumentException("Unknown notification type: " + notificationType);
        }
    }
}
