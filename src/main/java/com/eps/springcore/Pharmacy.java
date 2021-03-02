package com.eps.springcore;

public class Pharmacy {
	
	private String name;
	private String licenseNo;
	private String contactNo;
	private String Address;
	
	@Override
	public String toString() {
		return "Pharmacy [name=" + name + ", licenseNo=" + licenseNo + ", contactNo=" + contactNo + ", Address="
				+ Address + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLicenseNo() {
		return licenseNo;
	}
	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}

}
