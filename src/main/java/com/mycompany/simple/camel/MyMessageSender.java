/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simple.camel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 *
 * @author jan_s
 */
@Component
public class MyMessageSender {
  
    @Autowired
    JmsTemplate jmsTemplate;
    
   public void sendMessage(Object message)
   {
    jmsTemplate.convertAndSend(message);  
   }
    
}
