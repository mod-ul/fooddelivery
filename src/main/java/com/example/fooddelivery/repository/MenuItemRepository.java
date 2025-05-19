package com.example.fooddelivery.repository;
import com.example.fooddelivery.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {
	List<MenuItem> findByRestaurantId(int restaurantId);
}