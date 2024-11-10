package com.reservas.reservassalon.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "salones")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Salon {
    @Column(name="codigo_salon")
    @Id
    private String codigoSalon;
    @Column(name="nombre")
    private String nombre;
    @Column(name="ubicacion")
    private String ubicacion;
    @Column(name="capacidad")
    private int capacidad;
    @Column(name="descripcion")
    private String descripcion;

}
