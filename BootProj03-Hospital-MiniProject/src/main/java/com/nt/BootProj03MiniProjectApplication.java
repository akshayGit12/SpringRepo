package com.nt;

import java.io.Closeable;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.PayrollMgmtOperationsController;
import com.nt.model.Patient;

@SpringBootApplication
public class BootProj03MiniProjectApplication {

	public static void main(String[] args) {
		// get access to IOC container
		ApplicationContext ctx=SpringApplication.run(BootProj03MiniProjectApplication.class, args);
		
		// get controller Spring bean class object
		PayrollMgmtOperationsController controller=ctx.getBean("payroll-controller",PayrollMgmtOperationsController.class);
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter location1::");
		String location1=sc.next();

		System.out.println("Enter location2::");
		String location2=sc.next();

		// invoke the b.method
		try {
			List<Patient> list=controller.getPatientByLocation(location1, location2);
			// display the results
			System.out.println("EMployees belonging to "+ location1+"  "+location2+"are");
			list.forEach(hsp-> {
				System.out.println(hsp);
			});
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		// close the container
		((ConfigurableApplicationContext) ctx).close();
	}

}
