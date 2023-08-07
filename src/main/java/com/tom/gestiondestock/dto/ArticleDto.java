package com.tom.gestiondestock.dto;

import com.tom.gestiondestock.model.Article;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Builder
public class ArticleDto {

    private Integer id;

    private String codeArticle;

    private String designation;

    private BigDecimal prixUnitaireHt;

    private BigDecimal tauxTva;

    private BigDecimal prixUnitaireTtc;

    private String photo;

    private Integer idEntreprise;

    private CategoryDto category;

    public static ArticleDto fromEntity(Article article) {
        if (article == null) {
            return null;
        } else {
            return ArticleDto.builder()
                    .id(article.getId())
                    .codeArticle(article.getCodeArticle())
                    .designation(article.getDesignation())
                    .prixUnitaireHt(article.getPrixUnitaireHt())
                    .tauxTva(article.getTauxTva())
                    .prixUnitaireTtc(article.getPrixUnitaireTtc())
                    .photo(article.getPhoto())
                    .idEntreprise(article.getIdEntreprise())
                    .category(CategoryDto.fromEntity(article.getCategory()))
                    .build();
        }
    }

    public static Article toEntity(ArticleDto articleDto) {
        if (articleDto == null) {
            return null;
        } else {
            Article article = Article.builder()
                    .codeArticle(articleDto.getCodeArticle())
                    .designation(articleDto.getDesignation())
                    .prixUnitaireHt(articleDto.getPrixUnitaireHt())
                    .tauxTva(articleDto.getTauxTva())
                    .prixUnitaireTtc(articleDto.getPrixUnitaireTtc())
                    .photo(articleDto.getPhoto())
                    .idEntreprise(articleDto.getIdEntreprise())
                    .category(CategoryDto.toEntity(articleDto.getCategory()))
                    .build();

            article.setId(articleDto.getId());
            return article;
        }
    }
}
