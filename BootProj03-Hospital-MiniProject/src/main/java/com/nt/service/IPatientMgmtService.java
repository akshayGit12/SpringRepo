package com.nt.service;

import java.util.List;

import com.nt.model.Patient;

public interface IPatientMgmtService {

	public List<Patient> fetchPatientsByLocation(String location1,String location2) throws Exception;
}
