package com.nt.dao;

import java.util.List;

import com.nt.model.Patient;

public interface PatientDAO {
	public List<Patient> getPatientByLocation(String location1,String location2) throws Exception; 

}
