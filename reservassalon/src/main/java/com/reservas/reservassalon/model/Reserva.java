package com.reservas.reservassalon.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "reservas")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Reserva {

    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="documento_id_profesor")
    private String idProfesor;
    @Column(name="codigo_salon")
    private String codigoSalon;
    @Column(name="fecha_reserva")
    private Date fecha;
    @Column(name="hora_inicio")
    private Time horaInicio;
    @Column(name="hora_fin")
    private Time horaFin;

}
