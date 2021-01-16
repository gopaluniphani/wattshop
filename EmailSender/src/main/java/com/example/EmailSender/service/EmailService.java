package com.example.EmailSender.service;
import com.example.EmailSender.model.Invoice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmailService {
    void sendMail(String email, List<Invoice> invoice) throws Exception;
}
