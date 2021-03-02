package com.eps.springcore.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.eps.springcore.Doctors;

public class RowMapperDocImpl implements RowMapper<Doctors>{

	public Doctors mapRow(ResultSet rs, int rowNum) throws SQLException {
		Doctors doc= new Doctors();
		doc.setId(rs.getInt(1));
		doc.setfName(rs.getString(2));
		doc.setlName(rs.getString(3));
		doc.setLicenseNo(rs.getString(4));
		return doc;
	}
	
	
	
}
