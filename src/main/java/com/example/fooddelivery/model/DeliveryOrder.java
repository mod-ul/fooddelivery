package com.example.fooddelivery.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class DeliveryOrder {

	@Id
	private int id;
	private String customerName;
	private String address;
	private int restaurantId;
	private double totalPrice;

	public DeliveryOrder() {
	}

	public DeliveryOrder(int id, String customerName, String address, int restaurantId, double totalPrice) {
		this.id = id;
		this.customerName = customerName;
		this.address = address;
		this.restaurantId = restaurantId;
		this.totalPrice = totalPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
}