package com.eps.springcore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.eps.springcore.db.DrugDao;
import com.eps.springcore.db.DrugDaoImpl;

public class Order {
	private int srNo;
	private String drugName;
	private int drugQuantity;
	private String orderStatus;
	
	
	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public int getDrugQuantity() {
		return drugQuantity;
	}
	public void setDrugQuantity(int drugQuantity) {
		this.drugQuantity = drugQuantity;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	
	
	
//	public void getOrderDetails() throws NumberFormatException, IOException  {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		System.out.println("Enter which drug name you want to order from the above list");
//		drugName=br.readLine().toLowerCase();
//		setDrugName(drugName);
//		System.out.println("Enter quantity of this drug you want");
//		drugQuantity = Integer.parseInt(br.readLine());
//		setDrugQuantity(drugQuantity);
//	}
//	

	@Override
	public String toString() {
		return "Order [srNo=" + srNo + ", drugName=" + drugName + ", drugQuantity=" + drugQuantity + ", orderStatus="
				+ orderStatus + "]";
	}
	
}
// id , drug name, quantity, orderstatus:pending
//order : which drug and quantity
//order status : complete, pending
//ability to take pharma info
//