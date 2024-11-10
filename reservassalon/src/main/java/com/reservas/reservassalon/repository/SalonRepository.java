package com.reservas.reservassalon.repository;

import com.reservas.reservassalon.model.Salon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalonRepository extends JpaRepository<Salon, String> {

    boolean existsById(String codigo);
    void deleteById(String codigo);
}
