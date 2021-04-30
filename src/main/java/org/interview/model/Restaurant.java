package org.interview.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.Optional;
import java.util.function.Function;

@RequiredArgsConstructor
@EqualsAndHashCode
@ToString(exclude = {"dishResolver"})
public class Restaurant {
    @Getter
    private final String name;
    @Getter
    private final int stars;
    private final Function<Dish.Name, Optional<Dish>> dishResolver;

    //ATTENTION, it might block!
    //This method takes one second to return the result
    public Optional<Dish> findDish(Dish.Name dishName) {
        return dishResolver.apply(dishName);
    }
}
