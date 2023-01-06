package at.fhtw.swen3.services;

public interface EmailNotificationService {

    public void sendEmail(String receiver, String subject, String body);
}
