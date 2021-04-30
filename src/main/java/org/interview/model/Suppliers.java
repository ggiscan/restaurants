package org.interview.model;


import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Suppliers {

    private final static BigDecimal INCREMENT = new BigDecimal("0.25");

    private final static Function<Integer, Function<Dish.Name, Optional<Dish>>> withPriceByStars = stars -> dishName ->
            Optional.of(new Dish(dishName, dishName.getBasePrice().add(INCREMENT.multiply(new BigDecimal(stars - 1)))));

    public static final List<Restaurant> SMALL_CHAIN = IntStream.range(0, Runtime.getRuntime().availableProcessors() - 1)
            .mapToObj(i -> generate("R" + (i + 1), i % 5 + 1))
            .collect(Collectors.toList());

    public static final List<Restaurant> MEDIUM_CHAIN = IntStream.range(0, 50)
            .mapToObj(i -> generate("R" + (i + 1), i % 5 + 1))
            .collect(Collectors.toList());

    private static Restaurant generate(String name, int stars) {
        Function<Dish.Name, Optional<Dish>> delayedFn = dishName -> {
            sleep500Ms();
            return withPriceByStars.apply(stars).apply(dishName);
        };
        return new Restaurant(name, stars, delayedFn);
    }

    private static void sleep500Ms() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
