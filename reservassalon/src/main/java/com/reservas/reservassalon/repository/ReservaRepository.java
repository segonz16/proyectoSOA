package com.reservas.reservassalon.repository;

import com.reservas.reservassalon.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    boolean existsById(int id);
    void deleteById(int id);
    List<Reserva> findByCodigoSalon(String codigoSalon);
    List<Reserva> findByIdProfesor(String idProfesor);
}