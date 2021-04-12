package dev.ohjj.yorijori.api.menu;

import dev.ohjj.yorijori.api.controller.request.MenuRequest;
import dev.ohjj.yorijori.api.menu.model.Menu;
import dev.ohjj.yorijori.api.persistence.menu.entity.MenuEntity;
import dev.ohjj.yorijori.api.persistence.menu.repository.MenuRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class MenuService {
    private final MenuRepository menuRepository;

    public List<Menu> getMenu(long restaurantSeq, long menuCategorySeq) {
        return menuRepository.findAllByRestaurantSeqAndMenuCategorySeq(restaurantSeq, menuCategorySeq)
                .stream()
                .map(this::menuEntityToMenu)
                .collect(Collectors.toList());
    }

    public Menu getMenu(long menuSeq) {
        return menuRepository.findById(menuSeq)
                .map(this::menuEntityToMenu)
                .orElseThrow(RuntimeException::new);
    }

    public long addMenu(long restaurantSeq, long menuCategorySeq, String name, String description, int price,
                        boolean exposed, boolean ageRestricted, boolean represented, int viewOrder, long userSeq) {
        // TODO: 2021-04-12 restaurantSeq, menuCategorySeq 유효성 검사
        if (false) {
            throw new RuntimeException("");
        }

        final MenuEntity menuEntity = menuRepository.saveAndFlush(MenuEntity.from(restaurantSeq, menuCategorySeq, name, description, price,
                exposed, ageRestricted, represented, viewOrder, userSeq));

        return menuEntity.getSeq();
    }

    private Menu menuEntityToMenu(MenuEntity menuEntity) {
        return Menu.from(menuEntity.getSeq(),
                menuEntity.getRestaurantSeq(),
                menuEntity.getMenuCategorySeq(),
                menuEntity.getName(),
                menuEntity.getDescription(),
                menuEntity.getPrice(),
                menuEntity.getExposed(),
                menuEntity.getAgeRestricted(),
                menuEntity.getRepresented(),
                menuEntity.getViewOrder(),
                menuEntity.getCreatedAt(),
                menuEntity.getCreator(),
                menuEntity.getModifiedAt(),
                menuEntity.getModifier());
    }
}
