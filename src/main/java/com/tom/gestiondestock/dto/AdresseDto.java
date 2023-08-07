package com.tom.gestiondestock.dto;

import com.tom.gestiondestock.model.Adresse;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AdresseDto {
    private String adresse1;

    private String adresse2;

    private String ville;

    private String codePostal;

    private String pays;

    public static AdresseDto fromEntity(Adresse adresse) {
        if (adresse == null) {
            return null;
        } else {
            return AdresseDto.builder()
                    .adresse1(adresse.getAdresse1())
                    .adresse2(adresse.getAdresse2())
                    .ville(adresse.getVille())
                    .codePostal(adresse.getCodePostal())
                    .pays(adresse.getPays())
                    .build();
        }
    }

    public static Adresse toEntity(AdresseDto adresseDto) {
        if (adresseDto == null) {
            return null;
            // TODO: throw exception
        } else {
            return Adresse.builder()
                    .adresse1(adresseDto.getAdresse1())
                    .adresse2(adresseDto.getAdresse2())
                    .ville(adresseDto.getVille())
                    .codePostal(adresseDto.getCodePostal())
                    .pays(adresseDto.getPays())
                    .build();
        }
    }
}
