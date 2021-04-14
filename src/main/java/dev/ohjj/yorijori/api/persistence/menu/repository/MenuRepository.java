package dev.ohjj.yorijori.api.persistence.menu.repository;

import dev.ohjj.yorijori.api.persistence.menu.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity, Long> {
    List<MenuEntity> findAllByRestaurantSeqAndMenuCategorySeq(Long restaurantSeq, Long menuCategorySeq);
}
