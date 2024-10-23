package com.apimarket.market.adapters.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "sucursal", schema = "zemsania")
@Data
@NoArgsConstructor
public class SucursalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sucursal_id", unique = true, length = 7)
    @JsonProperty("sucursalId")
    private Long SucursalId;

    @Column(name = "direccion")
    @JsonProperty("direccion")
    private String Direccion;

    @Column(name = "franquicia_id")
    @JsonProperty("franquiciaId")
    private String FranquiciaId;

    @Column(name = "create_at")
    @JsonProperty("createAt")
    private Date createAt;

    @Column(name = "status")
    @JsonProperty("status")
    private String Status;

}
