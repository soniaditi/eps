package com.eps.springcore.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


import com.eps.springcore.Order;

public class RowMapperOrderImpl implements RowMapper<Order>{
	public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
		Order order= new Order();
		order.setSrNo(rs.getInt(1));
		order.setDrugName(rs.getString(2));
		order.setDrugQuantity(rs.getInt(3));
		order.setOrderStatus(rs.getString(4));
		return order;

	}
}
