package com.eps.springcore.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.eps.springcore.Doctors;
import com.eps.springcore.Order;
import com.eps.springcore.Pharmacy;

public class DoctorDaoImpl implements DoctorDao {
	
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	public int insert(Doctors doc) {
		//inserting data
		String query="insert into doctors(id,FirstName,LastName,LicenseNo) values(?,?,?,?)";
		int update=this.jdbcTemplate.update(query,doc.getId(),doc.getfName(),doc.getlName(),doc.getLicenseNo());
		return update;
	}

	public int update(Doctors doc) throws NumberFormatException, IOException{
		//updating data 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Doctors ID of whose record you want to update:");
		int id = Integer.parseInt(br.readLine());
		doc.setId(id);
		System.out.println("Enter changed First Name of the doc");
		String fName = br.readLine();
		fName.toLowerCase();
		doc.setfName(fName);
		System.out.println("Enter  changed Last Name of the doc");
		String lName = br.readLine();
		lName.toLowerCase();
		doc.setlName(lName);
		System.out.println("Enter changed License number");
		String licenseNo = br.readLine();
		licenseNo.toLowerCase();
		doc.setLicenseNo(licenseNo);
		String query="update doctors set FirstName=?, LastName=?, LicenseNo=? where id=?";
		int update = this.jdbcTemplate.update(query,doc.getfName(),doc.getlName(),doc.getLicenseNo(),doc.getId()); //ctr+1 to assign a value
		return update;
	}

	public int delete(int doctorsId) {
		String query="delete from doctors where id=?";
		int update = this.jdbcTemplate.update(query, doctorsId);
		return update;
	}

	public Doctors SearchByFname(String fName) {
		String query= "select * from doctors where FirstName=?";
		Doctors doc=null;
		try {
			doc=this.jdbcTemplate.queryForObject(query,new RowMapperDocImpl(), fName);
		}catch(EmptyResultDataAccessException e) {
			System.out.println("No Doctor by name " +fName+" is available in the database!!");
		}
		
		return doc;
	}
	public Doctors SearchByLname(String lName) {
		String query= "select * from doctors where LastName=?";
		Doctors doc=null;
		try {
			doc=this.jdbcTemplate.queryForObject(query,new RowMapperDocImpl(), lName);
		}catch(EmptyResultDataAccessException e) {
			System.out.println("No Doctor by name " +lName+" is available in the database!!");
		}
		return doc;
	}

	public List<Doctors> getAllDoctorsRecord() {
		String query="select * from doctors";
		List<Doctors> doc= this.jdbcTemplate.query(query, new RowMapperDocImpl());
		return doc;
		
	}


}
