package org.interview;

import org.apache.commons.lang3.tuple.Pair;
import org.interview.model.Dish;
import org.interview.model.Restaurant;
import org.interview.model.Suppliers;
import org.interview.service.DiscountService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/***
 * Write an algorithm to return the name of the Restaurant with the best offer for Pizza
 * Final price for pizza is the pizza's price minus discount received from the DiscountService
 * Break ties by the restaurant's stars (we prefer quality)
 * Focus on optimizing response latency, we don't want our customers to wait!
 * Do not worry about scalability of the solution, assume that the external blocking calls are in an external library
 */

public class Problem2 {

    private final static DiscountService discountService = new DiscountService();

    public static void main(String[] args) throws Exception {
        long start = System.nanoTime();
        List<Restaurant> smallChain = Suppliers.SMALL_CHAIN;

        Pair<Restaurant, Dish> bestDeal = bestDealFor(smallChain, Dish.Name.PIZZA);

        long total = System.nanoTime() - start;
        System.out.printf("[%d ms] Best deal is: %s%n", TimeUnit.NANOSECONDS.toMillis(total), bestDeal);
    }

    //can return null if no dish is found
    static Pair<Restaurant, Dish> bestDealFor(List<Restaurant> restaurants, Dish.Name dishName) throws Exception {
        return null;
    }

    private static List<Pair<Restaurant, Dish>> concatLists(List<Pair<Restaurant, Dish>> l1, List<Pair<Restaurant, Dish>> l2) {
        List<Pair<Restaurant, Dish>> result = new ArrayList<>(l1.size() + l2.size());
        result.addAll(l1);
        result.addAll(l2);
        return result;
    }
}
