package com.nt.model;

import lombok.Data;

// java bean
@Data
public class Employee {
	// java bean properties
	private int empno;
	private String ename;
	private String desg;
	private Double salary;
	private int deptno;
	private Double grossSalary;
	private Double netSalary;
	

}
