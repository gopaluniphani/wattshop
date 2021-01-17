package com.example.EmailSender.service.impl;

import com.example.EmailSender.model.Invoice;
import com.example.EmailSender.service.EmailService;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.List;
import java.util.Properties;

@Service
public class EmailServiceImpl implements EmailService {

    @Override
    public void sendMail(String email, List<Invoice> invoice) throws Exception{

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("wattshop.home@gmail.com", "wattshop_1234");
            }
        });

        int i=1;
        int totalPrice=0;

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("wattshop.home@gmail.com"));
        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(email));
        message.setSubject("Invoice of order dated: "+invoice.get(0).getDate());
        MimeMultipart multipart = new MimeMultipart();
        BodyPart messageBodyPart = new MimeBodyPart();
        String htmlHeading = "<h1>INVOICE!</h1>";
        messageBodyPart.setContent(htmlHeading,"text/html");
        multipart.addBodyPart(messageBodyPart);
        for (Invoice item: invoice) {
            messageBodyPart = new MimeBodyPart();
            String htmlThread = "<p>"+i+". "+item.getProductName()+"</p><img src=\""+item.getImageUrl()+"\"height = \"70\" width = \"70\"/><p>Qty: "+item.getQuantity()+" Price: "+item.getPrice()+"</p>";
            messageBodyPart.setContent(htmlThread,"text/html");
            multipart.addBodyPart(messageBodyPart);
            i++;
            totalPrice+=item.getQuantity()*item.getPrice();
        }
        messageBodyPart = new MimeBodyPart();
        String htmlFooter = "<h3>Total Price: "+totalPrice+"</h3><p>Thank You! Please visit us again.</p>";
        messageBodyPart.setContent(htmlFooter,"text/html");
        multipart.addBodyPart(messageBodyPart);
        message.setContent(multipart);
        Transport.send(message);
    }
}
