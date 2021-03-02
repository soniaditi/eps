package com.eps.springcore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Drug {
	
	private int id;
	private String medName;
	private String medBrand;
	private int quantity;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMedName() {
		return medName;
	}
	public void setMedName(String medName) {
		this.medName = medName;
	}
	public String getMedBrand() {
		return medBrand;
	}
	public void setMedBrand(String medBrand) {
		this.medBrand = medBrand;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void getDrugDetails() throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Drug ID:");
		id = Integer.parseInt(br.readLine());
		setId(id);
		System.out.println("Enter Drug Name");
		medName = br.readLine();
		medName.toLowerCase();
		setMedName(medName);
		System.out.println("Enter Drug brand");
		medBrand = br.readLine();
		medBrand.toLowerCase();
		setMedBrand(medBrand);
		System.out.println("Enter Drug quantity");
		quantity = Integer.parseInt(br.readLine());
		setQuantity(quantity);
		
	}
	@Override
	public String toString() {
		return "Drug [id=" + id + ", medName=" + medName + ", medBrand=" + medBrand + ", quantity=" + quantity + "]";
	}

}
