package com.eps.springcore.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCountCallbackHandler;

import com.eps.springcore.Drug;
import com.eps.springcore.Order;

public class DrugDaoImpl implements DrugDao {
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Drug drug) {
		String query="insert into drugs(id,medName,medBrand,quantity) values(?,?,?,?)";
		int update=this.jdbcTemplate.update(query,drug.getId(),drug.getMedName(),drug.getMedBrand(),drug.getQuantity());
		return update;
		
	}
	

	public void  updateById(Drug drug) throws NumberFormatException, IOException {
		//updating data 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Drug ID you want to update the record for:");
		int id = Integer.parseInt(br.readLine());
		drug.setId(id);
		System.out.println("Enter new Drug Name");
		drug.setMedName(br.readLine().toLowerCase());
		System.out.println("Enter new Drug brand");
		drug.setMedBrand(br.readLine().toLowerCase());
		System.out.println("Enter new Drug quantity");
		int quantity = Integer.parseInt(br.readLine());
		drug.setQuantity(quantity);
		
		String query="update drugs set medName=?, medBrand=?, quantity=? where id=?";
		int update = this.jdbcTemplate.update(query,drug.getMedName(),drug.getMedBrand(),drug.getQuantity(),drug.getId()); //ctr+1 to assign a value
		
	}

	public void updateQuantity(int quantityAdded,String medName) {
		
		String query="update drugs set quantity=? where medName=?";
		int update = this.jdbcTemplate.update(query,quantityAdded,medName); //ctr+1 to assign a value
		System.out.println("quantity updated");
		
		
	}
	public int delete(int drugId) {
		String query="delete from drugs where id=?";
		int update=0;
		try {
		update = this.jdbcTemplate.update(query, drugId);
		}catch(EmptyResultDataAccessException  e) {
			System.out.println("There's no such record in the in the database!!");
		}
		return update;
	}

	public Drug SearchByName(String medName) {
		String query= "select * from drugs where medName=?";
		Drug drug=null;
		try {
			drug=this.jdbcTemplate.queryForObject(query, new RowMapperDrugImpl(), medName);
			System.out.println(drug);
		}catch(EmptyResultDataAccessException e) {
			System.out.println("No Drug by name " +medName+" is available in the database!!");
		}
		if(drug.getQuantity()==0) 
			System.out.println("Quantity 0!! Drug out of stock. Please order by selecting the respective option");
	
		return drug;
		
	}
	//query,new RowMapperDrugImpl(), medName

	public Drug SearchByBrand(String medBrand) {
		String query= "select * from drugs where medBrand=?";
		Drug drug=null;
		try {
			drug=this.jdbcTemplate.queryForObject(query, new RowMapperDrugImpl(), medBrand);
			System.out.println(drug);
		}catch(EmptyResultDataAccessException e) {
			System.out.println("No Drug by brand " +medBrand+" is available in the database!!");
		}
		if(drug.getQuantity()==0) 
			System.out.println("Quantity 0!! Drug out of stock. Please order by selecting the respective option");
		
		return drug;
	}

	public List<Drug> getOutOfStockDrugList() {
		String query="select * from Drugs where quantity='0'";
		List<Drug> drugs=null;
		try {
			drugs= this.jdbcTemplate.query(query, new RowMapperDrugImpl());
		}catch(EmptyResultDataAccessException e) {
			System.out.println("No Drug is out of stock");
		}
		return drugs;
	}

	public int totalOrderCount() {
		RowCountCallbackHandler countCallback = new RowCountCallbackHandler();  // not reusable
		int rowCount=0;
		try {
		 jdbcTemplate.query("select * from drugs", countCallback);
		 rowCount = countCallback.getRowCount();
		}catch(Exception e) {
			System.out.println("Drug list is empty");
		}
		return rowCount;
	}

	public List<Drug> getAllDrugs() {
		String query="select * from drugs";
		List<Drug> drug= this.jdbcTemplate.query(query, new RowMapperDrugImpl());
		return drug;
	}
	
}


