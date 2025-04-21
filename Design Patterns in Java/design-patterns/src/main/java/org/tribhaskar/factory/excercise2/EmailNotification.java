package org.tribhaskar.factory.excercise2;

public class EmailNotification implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("Sending Email notification");
    }
}
