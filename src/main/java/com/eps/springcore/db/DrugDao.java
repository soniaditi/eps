package com.eps.springcore.db;

import java.io.IOException;
import java.util.List;

import com.eps.springcore.Doctors;
import com.eps.springcore.Drug;

public interface DrugDao {
	public int insert(Drug drug);
	public void  updateById(Drug drug) throws NumberFormatException, IOException;
	public void updateQuantity(int quantityAdded,String medName);
	public int delete(int drugId );
	public Drug SearchByName(String medName);
	public Drug SearchByBrand(String medBrand);
	public List<Drug> getOutOfStockDrugList();
	public int totalOrderCount();
	public List<Drug> getAllDrugs();
}
