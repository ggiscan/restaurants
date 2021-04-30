package org.interview;

import org.apache.commons.lang3.tuple.Pair;
import org.interview.model.Dish;
import org.interview.model.Restaurant;
import org.interview.model.Suppliers;
import org.interview.service.DiscountService;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Same as problem1, but use the MEDIUM chain
 */
public class Problem3 {

    private final static DiscountService discountService= new DiscountService();

    public static void main(String[] args) throws Exception {
        long start = System.nanoTime();
        List<Restaurant> smallChain = Suppliers.MEDIUM_CHAIN;

        Pair<Restaurant, Dish> bestDeal = bestDealFor(smallChain, Dish.Name.PIZZA);

        long total = System.nanoTime() - start;
        System.out.printf("[%d ms] Best deal is: %s%n", TimeUnit.NANOSECONDS.toMillis(total), bestDeal);
    }

    static Pair<Restaurant, Dish> bestDealFor(List<Restaurant> restaurants, Dish.Name dishName) {
        return null;
    }
}
