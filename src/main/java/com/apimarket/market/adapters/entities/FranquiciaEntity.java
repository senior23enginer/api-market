package com.apimarket.market.adapters.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "franquicia", schema = "zemsania")
@Data
@NoArgsConstructor
public class FranquiciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "franquicia_id", unique = true, length = 7)
    @JsonProperty("franquiciaId")
    private Long FranquicialId;

    @Column(name = "nombre")
    @JsonProperty("nombre")
    private String Nombre;

    @Column(name = "franquiciante")
    @JsonProperty("franquiciante")
    private String Franquiciante;

    @Column(name = "franquiciado")
    @JsonProperty("franquiciado")
    private String Franquiciado;

    @Column(name = "modelo_negocio")
    @JsonProperty("modeloNegocio")
    private String ModeloNegocio;

    @Column(name = "create_at")
    @JsonProperty("createAt")
    private Date createAt;

    @Column(name = "status")
    @JsonProperty("status")
    private String Status;

}
