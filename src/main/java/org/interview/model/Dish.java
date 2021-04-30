package org.interview.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
@Getter
public class Dish {

    public enum Name {
        PIZZA(BigDecimal.valueOf(7)),
        PASTA(BigDecimal.valueOf(9)),
        BURRITO(BigDecimal.valueOf(6)),
        SUSHI(BigDecimal.valueOf(15)),
        KEBAB(BigDecimal.valueOf(3));

        private final BigDecimal basePrice;

        Name(BigDecimal basePrice) {
            this.basePrice = basePrice;
        }

        public BigDecimal getBasePrice() {
            return basePrice;
        }
    }

    private final Name name;
    private final BigDecimal price;

    public Dish discounted(BigDecimal discount) {
        return new Dish(name, price.subtract(discount));
    }
}
