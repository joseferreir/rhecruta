/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.dac.core.uteis;

import java.io.Serializable;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.TextMessage;



/**
 *
 * @author laerton
 */
@Stateless
public class ProdutorQueue {
    @Inject
    @JMSConnectionFactory("jms/dac/ConnectionFactory")
    private JMSContext context;
    
    @Resource (lookup = "jms/dac/Queue")
    private Queue queue;
    
    public void enviar (Email email){
        JMSProducer createProducer =context.createProducer();
        ObjectMessage createEmail =  context.createObjectMessage(email);
        createProducer.send(queue, createEmail);
    }
    
}
