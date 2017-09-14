/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.core.uteis;

/**
 *
 * @author laerton
 */
import java.util.Properties;

import javax.ejb.Stateless;
import javax.enterprise.inject.Stereotype;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Stateless
public class JavaMailClass
{
    public void envia(final String email, final String senha, String emailDestino, String titulo, String corpo){
             Properties props = new Properties();
            /** Parâmetros de conexão com servidor Gmail */
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "587");
            Session session = Session.getDefaultInstance(props,
                        new javax.mail.Authenticator() {
                             protected PasswordAuthentication getPasswordAuthentication()
                             {
                                   return new PasswordAuthentication(email, senha);
                             }
                        });
             /** Ativa Debug para sessão */
            session.setDebug(true);
            try {

                  Message message = new MimeMessage(session);
                  message.setFrom(new InternetAddress(email)); //Remetente

                  Address[] toUser = InternetAddress //Destinatário(s)
                             .parse(emailDestino);  

                  message.setRecipients(Message.RecipientType.TO, toUser);
                  message.setSubject(titulo);//Assunto
                  message.setText(corpo);
                  /**Método para enviar a mensagem criada*/
                  Transport.send(message);

             } catch (MessagingException e) {
                  throw new RuntimeException(e);
            }
    }
    
 
}
