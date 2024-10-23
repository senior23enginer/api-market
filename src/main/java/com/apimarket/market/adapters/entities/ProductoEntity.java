package com.apimarket.market.adapters.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "producto", schema = "zemsania")
@Data
@NoArgsConstructor
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "producto_id", unique = true, length = 7)
    @JsonProperty("productoId")
    private Long ProductoId;

    @Column(name = "nombre")
    @JsonProperty("nombre")
    private String Nombre;

    @Column(name = "categoria")
    @JsonProperty("categoria")
    private String Categoria;

    @Column(name = "stock")
    @JsonProperty("stock")
    private int Stock;

    @Column(name = "sucursal_id")
    @JsonProperty("sucursalId")
    private Long SucursalId;

    @Column(name = "create_at")
    @JsonProperty("createAt")
    private Date CreateAt;

    @Column(name = "status")
    @JsonProperty("status")
    private String Status;

}
