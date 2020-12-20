package com.mayil1993.messaging.standaloneactivemqexample.listener;

import java.io.IOException;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mayil1993.messaging.standaloneactivemqexample.resource.User;

@Component
public class Consumer {

    @JmsListener(destination = "standalone.queue")
    public void consume(String user) throws JsonParseException, JsonMappingException, IOException {
    	
    	ObjectMapper ob = new ObjectMapper();
        System.out.println("Received Message: " + ob.readValue(user, User.class));
    }
}
