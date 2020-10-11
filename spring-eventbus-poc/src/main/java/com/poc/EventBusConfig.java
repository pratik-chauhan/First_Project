package com.poc;

import static reactor.bus.selector.Selectors.$;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.poc.listener.NotificationListener;
import com.poc.listener.PrintListener;

import reactor.Environment;
import reactor.bus.EventBus;

@Configuration
public class EventBusConfig implements CommandLineRunner {
	
	
	@Autowired
	private NotificationListener notificationListener;
	
	@Autowired
	private PrintListener printListener;

    @Bean
    Environment env() {
        return Environment.initializeIfEmpty().assignErrorJournal();
    }

    @Bean
    EventBus createEventBus(Environment env) {
        return EventBus.create(env, Environment.THREAD_POOL);
    }


    /* Listener registration to eventbus*/

	@Override
	public void run(String... args) throws Exception {
		createEventBus(env()).on($("notificationListener"), notificationListener); // Listener registration
		createEventBus(env()).on($("printListener"), printListener); // Listener registration
	}
    
}
