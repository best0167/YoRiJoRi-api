package dev.ohjj.yorijori.api.persistence.menu.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MenuRepositoryTest {
    @Autowired
    private MenuRepository menuRepository;

    @DisplayName("restaurantSeq로 메뉴 카테고리 리스트 조회")
    @Test
    void findAllByRestaurantSeqTest() {
        final var restaurantSeq = 1L;
        final var menuCategorySeq = 1L;
        menuRepository.findAllByRestaurantSeqAndMenuCategorySeq(restaurantSeq, menuCategorySeq)
                .forEach(System.out::println);
    }
}