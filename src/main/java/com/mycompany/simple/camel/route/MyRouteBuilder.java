/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.simple.camel.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 *
 * @author jan_s
 */
@Component
public class MyRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        System.out.println("Testing my route");
        from("{{activemq.sourcequeue}}").to("stream:out").to("activemq:targetqueue");      
      // from("activemq:sourcequeue").to("activemq:targetqueue");

    }

}
