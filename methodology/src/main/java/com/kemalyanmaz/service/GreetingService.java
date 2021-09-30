package com.kemalyanmaz.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.kemalyanmaz.aspect.Countable;
import com.kemalyanmaz.aspect.Loggable;

@Service
public class GreetingService {

	@Value("${app.greeting}")
    private String greeting;

    public GreetingService(){
        super();
    }

    @Loggable
    @Countable
    public String getGreeting(String name){
        return greeting + " " + name;
    }
}
