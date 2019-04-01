package com.chyn.allianz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.ApplicationPidFileWriter;

@SpringBootApplication
public class TwitterApp {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(TwitterApp.class);
		application.addListeners(new ApplicationPidFileWriter("./tmp/allianz-app.pid"));
		application.run();
	}

}
