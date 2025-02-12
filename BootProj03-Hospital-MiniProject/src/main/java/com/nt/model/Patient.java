package com.nt.model;

import lombok.Data;

// java bean
@Data
public class Patient {
	// java bean properties
	private int hospital_id;
	private String hospital_name;
	private int contact_number;
	private int total_beds;
	private int available_beds;
	private String location;
	private int patient_id;
	private String patient_name;
	private int age;
	private String gender;
	private String disease;

}
