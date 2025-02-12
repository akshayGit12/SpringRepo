package com.nt;

import java.io.Closeable;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.PayrollMgmtOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootProj03MiniProjectApplication {

	public static void main(String[] args) {
		// get access to IOC container
		ApplicationContext ctx=SpringApplication.run(BootProj03MiniProjectApplication.class, args);
		
		// get controller Spring bean class object
		PayrollMgmtOperationsController controller=ctx.getBean("payroll-controller",PayrollMgmtOperationsController.class);
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter desg1::");
		String desg1=sc.next();

		System.out.println("Enter desg2::");
		String desg2=sc.next();

		System.out.println("Enter desg3::");
		String desg3=sc.next();
		// invoke the b.method
		try {
			List<Employee> list=controller.showEmployeesByDesg(desg1, desg2, desg3);
			// display the results
			System.out.println("EMployees belonging to "+ desg1+"  "+desg2+"  "+desg3+"are");
			list.forEach(emp-> {
				System.out.println(emp);
			});
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		// close the container
		((ConfigurableApplicationContext) ctx).close();
	}

}
