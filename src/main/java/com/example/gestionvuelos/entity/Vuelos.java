package com.example.gestionvuelos.entity;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description="All details about the flies. ")
@Data //Usamos lombok para generar getters, setters, un constructor vacio, uno lleno y el metodo toString()
@Entity
@Table(name="vuelos")
public class Vuelos {

    @Id
    @Column(name="COD_VUELO")
    private String cod_vuelo;

    @Column(name="HORA_SALIDA")
    private String hora_salida;

    @Column(name="ORIGEN")
    private String origen;

    @Column(name="DESTINO")
    private String destino;

    @Column(name="PRECIO")
    private float precio;

    @Column(name="NUM_ESCALAS")
    private int num_escalas;

    @Column(name="COMPAÑIA")
    private String compañia;
}
