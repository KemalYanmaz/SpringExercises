package com.kemalyanmaz;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.kemalyanmaz.config.ApplicationConfig;
import com.kemalyanmaz.service.OutputService;

public class Application {

    public static void main(String[] args) throws Exception {
    	ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
    	OutputService outputService = context.getBean(OutputService.class);
    	    	
        for (int i=0;i<5;i++){
            outputService.generateOutput();
            Thread.sleep(2000);
        }
    }
}
