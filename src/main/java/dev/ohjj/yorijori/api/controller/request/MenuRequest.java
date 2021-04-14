package dev.ohjj.yorijori.api.controller.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MenuRequest {
    @Getter
    @Setter
    public static class CategoryCreationParam {
        private String name;
        private Boolean exposed;
        private Integer viewOrder;
    }

    @Getter
    @Setter
    public static class CreationParam {
        private String name;
        private String description;
        private Integer price;
        private Boolean exposed;
        private Boolean ageRestricted;
        private Boolean represented;
        private Integer viewOrder;
    }
}
