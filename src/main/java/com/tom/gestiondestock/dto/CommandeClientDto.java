package com.tom.gestiondestock.dto;

import com.tom.gestiondestock.model.CommandeClient;
import com.tom.gestiondestock.model.EtatCommande;
import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@Builder
public class CommandeClientDto {
    private Integer id;

    private String code;

    private Instant dateCommande;

    private EtatCommande etatCommande;

    private Integer idEntreprise;

    private ClientDto client;

    private List<LigneCommandeClientDto> ligneCommandeClients;

    public static CommandeClientDto fromEntity(CommandeClient commandeClient) {
        if (commandeClient == null) {
            return null;
        }
        return CommandeClientDto.builder()
                .id(commandeClient.getId())
                .code(commandeClient.getCode())
                .dateCommande(commandeClient.getDateCommande())
                .etatCommande(commandeClient.getEtatCommande())
                .client(ClientDto.fromEntity(commandeClient.getClient()))
                .idEntreprise(commandeClient.getIdEntreprise())
                .build();
    }

    public static CommandeClient toEntity(CommandeClientDto dto) {
        if (dto == null) {
            return null;
        }
        CommandeClient commandeClient = CommandeClient.builder()
                .code(dto.getCode())
                .dateCommande(dto.getDateCommande())
                .etatCommande(dto.getEtatCommande())
                .client(ClientDto.toEntity(dto.getClient()))
                .idEntreprise(dto.getIdEntreprise())
                .build();

        commandeClient.setId(dto.getId());
        return commandeClient;
    }

    public boolean isCommandeLivree() {
        return EtatCommande.LIVREE.equals(this.etatCommande);
    }
}
