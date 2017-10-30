/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simple.camel;


import javax.jms.Destination;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
//import org.apache.camel.spring.SpringCamelContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;

/**
 *
 * @author jan_s
 */
@Configuration
public class AppConfiguration {
    
     @Value("${spring.jms.broker.url}")
    private String brokerUrl;
    
    @Value("${spring.jms.source.queue.name}")
    private String queueName;
    
    @Bean
    public ActiveMQConnectionFactory connectionFactory()
    {
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory() ;
        connectionFactory.setBrokerURL(brokerUrl);        
        return connectionFactory;
    }
    
   
     @Bean
    public JmsTemplate jmsTemplate()
    {
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory()) ;
        Destination d = new ActiveMQQueue(queueName);        
        jmsTemplate.setDefaultDestination(d);
        return jmsTemplate;
    }
    
  /*  @Bean
    public SpringCamelContext camelContext(ApplicationContext applicationContext) throws Exception {
        SpringCamelContext camelContext = new SpringCamelContext(applicationContext);
      //  camelContext.setProperties(properties);
        camelContext.addRoutes(routeBuilder());
        return camelContext;
    }
    
    
    @Bean
    public MyRouteBuilder routeBuilder()
    {
        return new MyRouteBuilder();
    }        
            
   
    */
    
}
