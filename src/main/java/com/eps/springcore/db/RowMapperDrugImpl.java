package com.eps.springcore.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.eps.springcore.Drug;



public class RowMapperDrugImpl implements RowMapper<Drug> {
	
	public Drug mapRow(ResultSet rs, int rowNum) throws SQLException {
		Drug drug= new Drug();
		drug.setId(rs.getInt(1));
		drug.setMedName(rs.getString(2));
		drug.setMedBrand(rs.getString(3));
		drug.setQuantity(rs.getInt(4));
		return drug;
	}

}
