package com.tom.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tom.gestiondestock.model.Category;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryDto {
    private Integer id;

    private String code;

    private String designation;

    private Integer idEntreprise;

    @JsonIgnore
    private List<ArticleDto> articles;

    public static CategoryDto fromEntity(Category category) {
        if (category == null) {
            return null;
            // TODO: throw exception
        } else {
            return CategoryDto.builder()
                    .id(category.getId())
                    .code(category.getCode())
                    .designation(category.getDesignation())
                    .idEntreprise(category.getIdEntreprise())
                    .build();
        }
    }

    public static Category toEntity(CategoryDto categoryDto) {
        if (categoryDto == null) {
            return null;
            // TODO: throw exception
        } else {
            Category category = Category.builder()
                    .code(categoryDto.getCode())
                    .designation(categoryDto.getDesignation())
                    .idEntreprise(categoryDto.getIdEntreprise())
                    .build();

            category.setId(categoryDto.getId());
            return category;
        }
    }
}
