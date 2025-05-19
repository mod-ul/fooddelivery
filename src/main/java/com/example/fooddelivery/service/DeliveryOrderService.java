package com.example.fooddelivery.service;
import com.example.fooddelivery.model.DeliveryOrder;
import com.example.fooddelivery.repository.DeliveryOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DeliveryOrderService {

	@Autowired
	private DeliveryOrderRepository deliveryOrderRepository;

	public DeliveryOrder createOrder(DeliveryOrder order) {
		return deliveryOrderRepository.save(order);
	}

	public List<DeliveryOrder> getOrdersByCustomer(String customerName) {
		return deliveryOrderRepository.findByCustomerName(customerName);
	}
}