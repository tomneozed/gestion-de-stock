package com.tom.gestiondestock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tom.gestiondestock.model.Client;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ClientDto {
    private Integer id;

    private String nom;

    private String prenom;

    private AdresseDto adresse;

    private String photo;

    private String mail;

    private String numTel;

    private Integer idEntreprise;

    @JsonIgnore
    private List<CommandeClientDto> commandeClients;

    public static ClientDto fromEntity(Client client) {
        if (client == null) {
            return null;
            // TODO: throw exception
        } else {
            return ClientDto.builder()
                    .id(client.getId())
                    .nom(client.getNom())
                    .prenom(client.getPrenom())
                    .adresse(AdresseDto.fromEntity(client.getAdresse()))
                    .photo(client.getPhoto())
                    .mail(client.getMail())
                    .numTel(client.getNumTel())
                    .idEntreprise(client.getIdEntreprise())
                    .build();
        }
    }

    public static Client toEntity(ClientDto clientDto) {
        if (clientDto == null) {
            return null;
            // TODO: throw exception
        } else {
            Client client = Client.builder()
                    .nom(clientDto.getNom())
                    .prenom(clientDto.getPrenom())
                    .adresse(AdresseDto.toEntity(clientDto.getAdresse()))
                    .photo(clientDto.getPhoto())
                    .mail(clientDto.getMail())
                    .numTel(clientDto.getNumTel())
                    .idEntreprise(clientDto.getIdEntreprise())
                    .build();
            client.setId(clientDto.getId());
            return client;
        }
    }
}
