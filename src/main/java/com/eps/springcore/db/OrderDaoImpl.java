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
//import com.eps.springcore.select;

public class OrderDaoImpl implements OrderDao {
	private JdbcTemplate jdbcTemplate;
	private Order order=null;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Order> getAllOrders() {
		String query="select * from orders";
		List<Order> orders= this.jdbcTemplate.query(query, new RowMapperOrderImpl());
		return orders;
	}
	
	public int totalOrderCount() {
		 RowCountCallbackHandler countCallback = new RowCountCallbackHandler();
		try{// not reusable
		 jdbcTemplate.query("select * from orders", countCallback);
		}catch(Exception e) {
			return 0;
		}
		 int rowCount = countCallback.getRowCount();
		 return rowCount;
	}
	
	public void placeOrder() throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		order=new Order();
		int rows=totalOrderCount();
		if(rows==0) {
			order.setSrNo(1);
		}
		else
			order.setSrNo(rows+1);
		System.out.println("Enter which drug name you want to order from the above list");
		String drugName=br.readLine().toLowerCase();
		order.setDrugName(drugName);
		System.out.println("Enter quantity of this drug you want");
		int drugQuantity = Integer.parseInt(br.readLine());
		order.setDrugQuantity(drugQuantity);
		String query="update drugs set quantity=? where medName=?";
		int update1 = this.jdbcTemplate.update(query,order.getDrugQuantity(),order.getDrugName()); //ctr+1 to assign a value
		System.out.println("quantity updated");
		System.out.println("Enter the order status: (type completed or pending)");
		order.setOrderStatus(br.readLine().toLowerCase());
		query="insert into orders(SrNo,DrugName,quantity,OrderStatus) values(?,?,?,?)";
		int update=this.jdbcTemplate.update(query,order.getSrNo(),order.getDrugName(),order.getDrugQuantity(),order.getOrderStatus());
		System.out.println(update);
		System.out.println("Order placed successfully");
	}
	public void updateOrderStatus(String drugName, String OrderStatus) {
		
		String query="update Orders set OrderStatus=?, quantity='0' where DrugName=?";
		int update = this.jdbcTemplate.update(query,OrderStatus,drugName); //ctr+1 to assign a value
		String query1="update drugs set quantity ='0' where medName=?";
		int update1=this.jdbcTemplate.update(query1,drugName);
		System.out.println("status updated to "+OrderStatus);
		
		
		
	}
	
	public List<Order> getPendingOrdersList(){
		String query="select * from orders where OrderStatus='pending'";
		List<Order> pendingOrder=null;
		pendingOrder= this.jdbcTemplate.query(query, new RowMapperOrderImpl());
		if(pendingOrder.isEmpty()) {
			System.out.println("There are no pending orders");
			return null;
		}
		return pendingOrder;
		
	}
}
