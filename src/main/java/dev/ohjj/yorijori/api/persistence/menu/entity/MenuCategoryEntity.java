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
        name = "menu_category",
        indexes = @Index(name = "idx_restaurant_seq", columnList = "restaurant_seq")
)
public class MenuCategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq")
    private Long seq;

    @Column(name = "restaurant_seq", nullable = false)
    private Long restaurantSeq;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "exposed", nullable = false)
    private Boolean exposed;

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

    public MenuCategoryEntity(long restaurantSeq, String name, boolean exposed, int viewOrder) {
        this.restaurantSeq = restaurantSeq;
        this.name = name;
        this.exposed = exposed;
        this.viewOrder = viewOrder;
    }

    public static MenuCategoryEntity from(long restaurantSeq, String name, boolean exposed, int viewOrder, long userSeq) {
        final MenuCategoryEntity menuCategoryEntity = new MenuCategoryEntity(restaurantSeq, name, exposed, viewOrder);
        final LocalDateTime now = LocalDateTime.now();
        menuCategoryEntity.createdAt = now;
        menuCategoryEntity.creator = userSeq;
        menuCategoryEntity.modifiedAt = now;
        menuCategoryEntity.modifier = userSeq;
        return menuCategoryEntity;
    }
}
