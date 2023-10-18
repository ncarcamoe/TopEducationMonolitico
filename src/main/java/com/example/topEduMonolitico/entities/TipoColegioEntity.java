package com.example.topEduMonolitico.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "tipoColegio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoColegioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipoColegio;

    private String descripcion;
    private Short maximoCuotas;
    private Short porcDescuento;

}
