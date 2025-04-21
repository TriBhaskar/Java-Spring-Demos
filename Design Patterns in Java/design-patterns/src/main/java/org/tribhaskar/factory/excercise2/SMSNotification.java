package org.tribhaskar.factory.excercise2;

public class SMSNotification implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("Sending SMS notification");
    }
}
