package dev.ohjj.yorijori.api.persistence.menu.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(
        name = "menu",
        indexes = {
                @Index(name = "idx_restaurant_seq", columnList = "restaurant_seq"),
                @Index(name = "idx_menu_category_seq", columnList = "menu_category_seq")
        }
)
public class MenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")
    private Long seq;

    @Column(name = "restaurant_seq", nullable = false)
    private Long restaurantSeq;

    @Column(name = "menu_category_seq", nullable = false)
    private Long menuCategorySeq;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "description", nullable = false, length = 300)
    private String description;

    @Column(name = "price", nullable = false)
    private Integer price;

    @Column(name = "exposed", nullable = false)
    private Boolean exposed;

    @Column(name = "age_restricted", nullable = false)
    private Boolean ageRestricted;

    @Column(name = "represented", nullable = false)
    private Boolean represented;

    @Column(name = "view_order", nullable = false)
    private Integer viewOrder;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "creator", nullable = false)
    private Long creator;

    @Column(name = "modified_at", nullable = false)
    private LocalDateTime modifiedAt;

    @Column(name = "modifier", nullable = false)
    private Long modifier;

    public MenuEntity(long restaurantSeq, long menuCategorySeq, String name, String description, int price,
                      boolean exposed, boolean ageRestricted, boolean represented, int viewOrder) {
        this.restaurantSeq = restaurantSeq;
        this.menuCategorySeq = menuCategorySeq;
        this.name = name;
        this.description = description;
        this.price = price;
        this.exposed = exposed;
        this.ageRestricted = ageRestricted;
        this.represented = represented;
        this.viewOrder = viewOrder;
    }

    public static MenuEntity from(long restaurantSeq, long menuCategorySeq, String name, String description, int price,
                                  boolean exposed, boolean ageRestricted, boolean represented, int viewOrder, long userSeq) {
        final MenuEntity menuEntity = new MenuEntity(restaurantSeq, menuCategorySeq, name, description, price, exposed, ageRestricted, represented, viewOrder);
        final LocalDateTime now = LocalDateTime.now();
        menuEntity.createdAt = now;
        menuEntity.creator = userSeq;
        menuEntity.modifiedAt = now;
        menuEntity.modifier = userSeq;
        return menuEntity;
    }
}
