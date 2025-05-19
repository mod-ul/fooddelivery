package com.example.fooddelivery.controller;
import java.util.List;
import com.example.fooddelivery.model.MenuItem;
import com.example.fooddelivery.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//ВАРІАНТ 5: Сервіс доставки їжі
@RestController
@RequestMapping("/api")
public class MenuItemController {

	@Autowired
	private MenuItemService menuItemService;

	// GET /menu/{restaurantId} — меню ресторану
	@RequestMapping("/menu/{restaurantId}")
	public ResponseEntity<List<MenuItem>> getMenuByRestaurantId(@PathVariable("restaurantId") int restaurantId) {
		List<MenuItem> menuItems = menuItemService.getMenuByRestaurantId(restaurantId);
		if (menuItems.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(menuItems, HttpStatus.OK);
	}

	// POST /menu — додати позицію в меню
	@RequestMapping(value = "/menu", method = RequestMethod.POST)
	public ResponseEntity<MenuItem> createMenuItem(@RequestBody MenuItem menuItem) {
		MenuItem createdMenuItem = menuItemService.createMenuItem(menuItem);
		if (createdMenuItem == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(createdMenuItem, HttpStatus.CREATED);
	}
}