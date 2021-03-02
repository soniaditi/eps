package com.eps.springcore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Scanner;


public class Doctors {
	private int id;
	private String fName;
	private String lName;
	private String licenseNo;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	

	
	public void getDocDetails() throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Doctors ID:");
		id = Integer.parseInt(br.readLine());
		setId(id);
		System.out.println("Enter Doc First Name");
		fName = br.readLine();
		fName.toLowerCase();
		setfName(fName);
		System.out.println("Enter Doc Last Name");
		lName = br.readLine();
		lName.toLowerCase();
		setlName(lName);
		System.out.println("Enter Doc License number");
		licenseNo = br.readLine();
		licenseNo.toLowerCase();
		setLicenseNo(licenseNo);
		
	}
	
	@Override
	public String toString() {
		return "Doctors [id=" + id + ", fName=" + fName + ", lName=" + lName + ", licenseNo=" + licenseNo + "]";
	}
}
