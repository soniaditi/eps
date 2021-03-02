package com.eps.springcore.db;

import java.io.IOException;
import java.util.List;

import com.eps.springcore.*;

public interface OrderDao {
	public List<Order> getAllOrders();
	public int totalOrderCount();
	public void placeOrder() throws NumberFormatException, IOException;
	public List<Order> getPendingOrdersList();
	public void updateOrderStatus(String drugName, String OrderStatus);

}
