package com.example.fooddelivery.controller;
import java.util.List;
import com.example.fooddelivery.model.DeliveryOrder;
import com.example.fooddelivery.service.DeliveryOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//ВАРІАНТ 5: Сервіс доставки їжі
@RestController
@RequestMapping("/api")
public class DeliveryOrderController {

	@Autowired
	private DeliveryOrderService deliveryOrderService;

	// POST /orders — оформити замовлення
	@RequestMapping(value = "/orders", method = RequestMethod.POST)
	public ResponseEntity<DeliveryOrder> createOrder(@RequestBody DeliveryOrder order) {
		DeliveryOrder createdOrder = deliveryOrderService.createOrder(order);
		if (createdOrder == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
	}

	// GET /orders/by-customer — перегляд замовлень по імені
	@GetMapping("/orders/by-customer")
	public ResponseEntity<List<DeliveryOrder>> getOrdersByCustomer(@RequestParam String customerName) {
		List<DeliveryOrder> orders = deliveryOrderService.getOrdersByCustomer(customerName);
		if (orders.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}
}