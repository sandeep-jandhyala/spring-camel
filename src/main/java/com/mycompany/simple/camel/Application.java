/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simple.camel;




import com.mycompany.simple.camel.jms.MyMessageSender;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@SpringBootApplication
public class Application {
    
    
    public static void main(String[] args) {
        // Launch the application
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
        MyMessageSender sender=  context.getBean(MyMessageSender.class);
        System.out.println("Sending a sample message.");        
       sender.sendMessage("Hello");
        
    }

}
