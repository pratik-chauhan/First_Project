package com.poc.customstarter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.poc.customstarter.service.DefaultMessageService;
import com.poc.customstarter.service.MessageService;

@Configuration
public class CustomMessageAutoConfiguration {

   @Bean	
   public MessageService messageService() {
	   return new DefaultMessageService();
   }

}
