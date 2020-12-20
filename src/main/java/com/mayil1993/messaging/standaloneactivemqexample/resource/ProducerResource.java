package com.mayil1993.messaging.standaloneactivemqexample.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.jms.Queue;

@RestController
@RequestMapping("/rest/publish")
public class ProducerResource {

    @Autowired
    JmsTemplate jmsTemplate;

    @Autowired
    Queue queue;
    
    

    @PostMapping("/post")
    public String publish(@RequestBody User user) throws JmsException, JsonProcessingException {

    	ObjectMapper ob = new ObjectMapper();
        jmsTemplate.convertAndSend(queue, ob.writeValueAsString(user));

        return "Published Successfully";
    }
}
