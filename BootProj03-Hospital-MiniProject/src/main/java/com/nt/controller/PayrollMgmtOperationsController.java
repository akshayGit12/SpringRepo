package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Patient;
import com.nt.service.IPatientMgmtService;

@Controller("payroll-controller")
public class PayrollMgmtOperationsController {
	@Autowired
	private IPatientMgmtService hspService;
	
	public List<Patient> getPatientByLocation(String location1, String location2) throws Exception{
		// use service
		List<Patient> list=hspService.fetchPatientsByLocation(location1, location2);
	
		return list;
	}
}
