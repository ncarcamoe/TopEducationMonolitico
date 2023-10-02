package com.example.topEduMonolitico.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "colegio")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColegioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idColegio;

    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_colegio")
    private TipoColegioEntity tipoColegio;


}
