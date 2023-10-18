package com.example.topEduMonolitico.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "estudiante")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstudianteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEstudiante;

    private String rut;
    private String nombre;
    private String email;
    private String apellidoPrimario;
    private String apellidoSecundario;
    private Date fechaNacimiento;
    private Short anioEgreso;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_colegio")
    private ColegioEntity colegio;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL)
    private Set<CuotaEntity> cuota = new HashSet<>();

}
