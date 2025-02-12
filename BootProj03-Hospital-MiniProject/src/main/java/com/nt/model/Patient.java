package com.nt.model;

import lombok.Data;

// java bean
@Data
public class Patient {
	// java bean properties
	private int patient_id;
	private String patient_name;
	private int age;
	private String gender;
	private String disease;

}
