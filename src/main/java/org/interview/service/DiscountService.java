package org.interview.service;

import org.interview.model.Dish;
import org.interview.model.Restaurant;

import java.math.BigDecimal;

public class DiscountService {

    public Dish applyDiscount(Restaurant restaurant, Dish dish) {
        if (restaurant.getName().equals("R5")) {
            return dish.discounted(BigDecimal.ONE);
        }
        return dish;
    }
}
