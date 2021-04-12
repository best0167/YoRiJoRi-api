package dev.ohjj.yorijori.api.menu.category.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class MenuCategory {
    private final Long seq;
    private final Long restaurantSeq;
    private final String name;
    private final Boolean exposed;
    private final Integer viewOrder;
    private final LocalDateTime createdAt;
    private final Long creator;
    private final LocalDateTime modifiedAt;
    private final Long modifier;

    public static MenuCategory from(Long seq, Long restaurantSeq, String name,
                                    Boolean exposed, Integer viewOrder, LocalDateTime createdAt,
                                    Long creator, LocalDateTime modifiedAt, Long modifier) {
        return new MenuCategory(seq, restaurantSeq, name, exposed, viewOrder, createdAt, creator, modifiedAt, modifier);
    }
}
