package dev.ohjj.yorijori.api.menu.model;

import dev.ohjj.yorijori.api.menu.category.model.MenuCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Menu {
    private final Long seq;
    private final Long restaurantSeq;
    private final Long menuCategorySeq;
    private final String name;
    private final String description;
    private final Integer price;
    private final Boolean exposed;
    private final Boolean ageRestricted;
    private final Boolean represented;
    private final Integer viewOrder;
    private final LocalDateTime createdAt;
    private final Long creator;
    private final LocalDateTime modifiedAt;
    private final Long modifier;

    public static Menu from(Long seq, Long restaurantSeq, Long menuCategorySeq, String name, String description, Integer price,
                            Boolean exposed, Boolean ageRestricted, Boolean represented, Integer viewOrder, LocalDateTime createdAt,
                            Long creator, LocalDateTime modifiedAt, Long modifier) {
        return new Menu(seq, restaurantSeq, menuCategorySeq, name, description, price, exposed, ageRestricted,
                represented, viewOrder, createdAt, creator, modifiedAt, modifier);
    }
}
