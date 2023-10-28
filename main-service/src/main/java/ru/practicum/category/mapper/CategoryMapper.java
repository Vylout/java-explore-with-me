package ru.practicum.category.mapper;

import ru.practicum.category.model.dto.CategoryDto;
import ru.practicum.category.model.dto.NewCategoryDto;
import ru.practicum.category.model.entity.Category;

import java.util.ArrayList;
import java.util.List;

public class CategoryMapper {
    public static Category toCategory(NewCategoryDto newCategoryDto) {
        return Category.builder()
                .name(newCategoryDto.getName())
                .build();
    }

    public static CategoryDto toCategoryDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public static List<CategoryDto> toCategoryDto(Iterable<Category> categories) {
        List<CategoryDto> result = new ArrayList<>();

        for (Category c : categories) {
            result.add(toCategoryDto(c));
        }

        return result;
    }
}
