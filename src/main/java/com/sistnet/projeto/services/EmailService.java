package com.sistnet.projeto.services;

import com.sistnet.projeto.domain.Pedido;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendOrderConfirmationEmail(Pedido obj);

    void sendEmail(SimpleMailMessage obj);
}
