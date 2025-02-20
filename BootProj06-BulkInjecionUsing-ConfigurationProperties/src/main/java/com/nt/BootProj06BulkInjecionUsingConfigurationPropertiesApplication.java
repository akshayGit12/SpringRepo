package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.sbeans.PersonDetails;

@SpringBootApplication
public class BootProj06BulkInjecionUsingConfigurationPropertiesApplication {

	public static void main(String[] args) {
		// access IOC container
		ApplicationContext ctx=SpringApplication.run(BootProj06BulkInjecionUsingConfigurationPropertiesApplication.class, args);
		// get access to spring bean class obj ref
		PersonDetails details = ctx.getBean("pDetails",PersonDetails.class);
		// display the data 
		System.out.println("Data is :: "+details);
		
		// close the IOC container
		((ConfigurableApplicationContext) ctx).close();
	}

}
