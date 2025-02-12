package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.model.Patient;

@Repository("hspDAO")
public class PatientDAOImpl implements PatientDAO {
	@Autowired
	private DataSource ds; // HAS-A property 
	
	// SQL Query 
	/*private static final String GET_HSP_QUERY="SELECT p.patient_id, p.patient_name, p.age, p.gender, p.disease, h.hospital_name, h.location \r\n"
			+ "FROM patient p\r\n"
			+ "JOIN hospital h ON p.hospital_id = h.hospital_id\r\n"
			+ "WHERE h.location IN (?, ?)\r\n"
			+ "ORDER BY LOCATION";*/
	private static final String GET_HSP_QUERY="SELECT * FROM HOSPITAL WHERE LOCATION IN(?,?)";

	@Override
	public List<Patient> getPatientByLocation(String location1, String location2) throws Exception {
		
		// write jdbc code
		List <Patient> list=new ArrayList<>();
		// get pooled jdbc connection
		// get PrepareStatement object with pre compiled SQL Query 
		try(Connection con=ds.getConnection();
				PreparedStatement ps=con.prepareStatement(GET_HSP_QUERY);
				){
			// set values to Query params
			ps.setString(1, location1);
			ps.setString(2, location2);
			// execute the select SQL Query 
			try(ResultSet rs=ps.executeQuery()){
				// process the ResultSet object to List<Employee> object
				while(rs.next()) {
					// copy each record into model class object
					Patient patient=new Patient();
					patient.setPatient_id(rs.getInt(1));
					patient.setPatient_name(rs.getString(2));
					patient.setAge(rs.getInt(3));
					patient.setGender(rs.getString(4));
					patient.setDisease(rs.getNString(5));
					// add Employee class object to List collection
					list.add(patient);
				}//while
			}// nested try
		}// outer try 
		catch(SQLException se) {
			se.printStackTrace();
			throw se;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		return list;
	}
}
