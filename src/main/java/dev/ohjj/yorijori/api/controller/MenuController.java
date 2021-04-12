package dev.ohjj.yorijori.api.controller;

import dev.ohjj.yorijori.api.controller.request.MenuRequest;
import dev.ohjj.yorijori.api.menu.MenuService;
import dev.ohjj.yorijori.api.menu.category.MenuCategoryService;
import dev.ohjj.yorijori.api.menu.category.model.MenuCategory;
import dev.ohjj.yorijori.api.menu.model.Menu;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/restaurants/{restaurantSeq}")
public class MenuController {
    private final MenuService menuService;
    private final MenuCategoryService menuCategoryService;

    @GetMapping("/menu-categories")
    public List<MenuCategory> getCategories(@PathVariable Long restaurantSeq) {
        return menuCategoryService.getMenuCategories(restaurantSeq);
    }

    @PostMapping("/menu-categories")
    @ResponseStatus(HttpStatus.CREATED)
    public long addMenuCategory(@PathVariable Long restaurantSeq, @RequestBody MenuRequest.CategoryCreationParam categoryCreationParam,
                                @RequestParam long userSeq) {
        return menuCategoryService.addMenuCategory(restaurantSeq, categoryCreationParam.getName(),
                categoryCreationParam.getExposed(), categoryCreationParam.getViewOrder(), userSeq);
    }

    @GetMapping("/menu-categories/{menuCategorySeq}/menus")
    public List<Menu> getMenus(@PathVariable Long restaurantSeq, @PathVariable Long menuCategorySeq) {
        return menuService.getMenu(restaurantSeq, menuCategorySeq);
    }

    @GetMapping("/menu-categories/{menuCategorySeq}/menus/{menuSeq}")
    public Menu getMenu(@PathVariable Long restaurantSeq, @PathVariable Long menuCategorySeq, @PathVariable Long menuSeq) {
        return menuService.getMenu(menuSeq);
    }

    @PostMapping("/menu-categories/{menuCategorySeq}/menus")
    @ResponseStatus(HttpStatus.CREATED)
    public long addMenu(@PathVariable Long restaurantSeq, @PathVariable Long menuCategorySeq,
                              @RequestBody MenuRequest.CreationParam creationParam, @RequestParam long userSeq) {
        return menuService.addMenu(restaurantSeq, menuCategorySeq, creationParam.getName(), creationParam.getDescription(), creationParam.getPrice(),
                creationParam.getExposed(), creationParam.getAgeRestricted(), creationParam.getRepresented(), creationParam.getViewOrder(), userSeq);
    }
}
