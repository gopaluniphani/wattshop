package com.example.EmailSender.controller;

import com.example.EmailSender.model.Invoice;
import com.example.EmailSender.service.EmailService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/sendmail")
public class EmailController {

    private List<Invoice> invoices;

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    @Autowired
    EmailService emailService;

    @PostMapping(value = "/{userEmail}")
    public String sendmail(@PathVariable("userEmail") String email,@RequestBody String jsonInvoice) throws Exception {
        List<Invoice> invoice = new ObjectMapper().readValue(
                jsonInvoice, new TypeReference<List<Invoice>>() { }
        );
        emailService.sendMail(email,invoice);
        return "The invoice has been sent on your mail!";
    }
}
