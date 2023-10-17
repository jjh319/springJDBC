package org.zerock.myapp;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

@Log4j2
@NoArgsConstructor

@SpringBootApplication
public class SpringJdbcApplication
		extends ServletInitializer
		implements ApplicationListener<ApplicationEvent> {

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);

	} // main

	@Override
	public void onApplicationEvent(ApplicationEvent event) {

	} // onApplicationEvent

} // end class
