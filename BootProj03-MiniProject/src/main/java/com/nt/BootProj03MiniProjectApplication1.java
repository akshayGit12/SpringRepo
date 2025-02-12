package com.nt;

import java.io.Closeable;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.controller.PayrollMgmtOperationsController;
import com.nt.model.Employee;

@SpringBootApplication
public class BootProj03MiniProjectApplication1 {

	public static void main(String[] args) {
		try(
				// get access to IOC container
				ConfigurableApplicationContext ctx=SpringApplication.run(BootProj03MiniProjectApplication1.class, args);
				Scanner sc=new Scanner(System.in);
		){
		// get controller Spring bean class object
		PayrollMgmtOperationsController controller=ctx.getBean("payroll-controller",PayrollMgmtOperationsController.class);
		
		System.out.println("Enter desg1::");
		String desg1=sc.next();

		System.out.println("Enter desg2::");
		String desg2=sc.next();

		System.out.println("Enter desg3::");
		String desg3=sc.next();
		// invoke the b.method
	
			List<Employee> list=controller.showEmployeesByDesg(desg1, desg2, desg3);
			// display the results
			System.out.println("EMployees belonging to "+ desg1+"  "+desg2+"  "+desg3+"are");
			list.forEach(emp-> {
				System.out.println(emp);
			});
		}//try
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			System.out.println("Internal Problem"+e.getMessage());
			e.printStackTrace();
		}//main
	}	// class
}
