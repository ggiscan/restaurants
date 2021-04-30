package org.interview;

import org.apache.commons.lang3.tuple.Pair;
import org.interview.model.Dish;
import org.interview.model.Restaurant;
import org.interview.model.Suppliers;
import org.interview.service.DiscountService;

import java.math.BigDecimal;
import java.util.ArrayList;
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
