package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.PatientDAO;
import com.nt.model.Patient;

@Service("hspService")
public class IPatientMgmtServiceImpl implements IPatientMgmtService{
	@Autowired
	private PatientDAO hspDAO;

	@Override
	public List<Patient> fetchPatientsByLocation(String location1, String location2) throws Exception {
		// converts the location (inputs ) upper case latters
		location1=location1.toUpperCase();
		location2=location2.toUpperCase();
		//use DAO
		List<Patient> list=hspDAO.getPatientByLocation(location1, location2);
		/*// calculate gross salary and net salary
		list.forEach(emp->{
			emp.setGrossSalary(emp.getSalary()+(emp.getSalary()*0.4));
			emp.setNetSalary(emp.getGrossSalary()-(emp.getGrossSalary()*0.15));
		});*/
		
		return list;
	}

}
