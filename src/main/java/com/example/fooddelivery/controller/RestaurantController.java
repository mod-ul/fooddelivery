package com.example.fooddelivery.controller;
import java.util.List;
import com.example.fooddelivery.model.Restaurant;
import com.example.fooddelivery.service.RestaurantService;
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
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;

	// GET /restaurants — всі ресторани
	@RequestMapping("/restaurants")
	public ResponseEntity<List<Restaurant>> getAllRestaurants() {
		List<Restaurant> restaurants = restaurantService.getAllRestaurants();
		return new ResponseEntity<>(restaurants, HttpStatus.OK);
	}

	// POST /restaurants — додати ресторан
	@RequestMapping(value = "/restaurants", method = RequestMethod.POST)
	public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
		Restaurant createdRestaurant = restaurantService.createRestaurant(restaurant);
		if (createdRestaurant == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(createdRestaurant, HttpStatus.CREATED);
	}

	// GET /restaurants/{id} — ресторан за ID
	@RequestMapping("/restaurants/{id}")
	public ResponseEntity<Restaurant> getRestaurantById(@PathVariable("id") int id) {
		Restaurant restaurant = restaurantService.getRestaurantById(id);
		if (restaurant == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(restaurant, HttpStatus.OK);
	}
}