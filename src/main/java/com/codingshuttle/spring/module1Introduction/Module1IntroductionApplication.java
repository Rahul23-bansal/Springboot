package com.codingshuttle.spring.module1Introduction;

import com.codingshuttle.spring.module1Introduction.impl.EmailNotificationService;
import com.codingshuttle.spring.module1Introduction.impl.SmsNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class Module1IntroductionApplication implements CommandLineRunner {

	//Field DI (Not recommended)
//	@Autowired
//	final NotificationService notificationServiceObj;

	//Constructor Dependency Injection(Recommended due to immutability)
//	public Module1IntroductionApplication(NotificationService notificationServiceObj){
//		this.notificationServiceObj = notificationServiceObj;
//	}

	@Autowired
	Map<String, NotificationService> notificationServiceMap = new HashMap<>();

	public static void main(String[] args) {
		SpringApplication.run(Module1IntroductionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
//		notificationServiceObj.send("Hello");

		for (var notificationService: notificationServiceMap.entrySet()){
			System.out.println(notificationService.getKey());
			notificationService.getValue().send("Hello");
		}
	}

}


// tight coupling is very bad
