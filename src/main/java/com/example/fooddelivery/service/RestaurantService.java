package com.example.fooddelivery.service;
import com.example.fooddelivery.model.Restaurant;
import com.example.fooddelivery.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;

	public List<Restaurant> getAllRestaurants() {
		return restaurantRepository.findAll();
	}

	public Restaurant createRestaurant(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}

	public Restaurant getRestaurantById(int id) {
		return restaurantRepository.findById(id).orElse(null);
	}
}