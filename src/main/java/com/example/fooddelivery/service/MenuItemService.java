package com.example.fooddelivery.service;
import com.example.fooddelivery.model.MenuItem;
import com.example.fooddelivery.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuItemService {

	@Autowired
	private MenuItemRepository menuItemRepository;

	public List<MenuItem> getMenuByRestaurantId(int restaurantId) {
		return menuItemRepository.findByRestaurantId(restaurantId);
	}

	public MenuItem createMenuItem(MenuItem menuItem) {
		return menuItemRepository.save(menuItem);
	}
}