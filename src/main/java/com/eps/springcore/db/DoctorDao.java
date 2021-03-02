package com.eps.springcore.db;

import java.io.IOException;
import java.util.List;

import com.eps.springcore.Doctors;
import com.eps.springcore.Drug;

public interface DoctorDao {
	
	public int insert(Doctors doc);
	public int update(Doctors doc) throws NumberFormatException, IOException;
	public int delete(int DoctorsId );
	public Doctors SearchByFname(String fName);
	public Doctors SearchByLname(String lName);
	public List<Doctors> getAllDoctorsRecord();
}
