package com.example.fooddelivery.repository;
import com.example.fooddelivery.model.DeliveryOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface DeliveryOrderRepository extends JpaRepository<DeliveryOrder, Integer> {
	List<DeliveryOrder> findByCustomerName(String customerName);
}