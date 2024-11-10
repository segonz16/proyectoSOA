package com.reservas.reservassalon.service;

import com.reservas.reservassalon.model.Reserva;
import com.reservas.reservassalon.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {
    @Autowired

    private ReservaRepository reservaRepository;

    public Reserva create(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public List<Reserva> getAllResevas() {
        return reservaRepository.findAll();
    }

    public void deleteById(int id) {
        reservaRepository.deleteById(id);
    }

    public Optional<Reserva> findById(int id) {
        return reservaRepository.findById(id);
    }

    public boolean existsById(int id) {
        return reservaRepository.existsById(id);
    }
    public boolean notExistsById(int id) {
        return !reservaRepository.existsById(id);
    }

    public List<Reserva> findByCodigoSalon(String codigoSalon) {
        return reservaRepository.findByCodigoSalon(codigoSalon);
    }
    public List<Reserva> findByIdProfesor(String idProfesor) {
        return reservaRepository.findByIdProfesor(idProfesor);
    }



}
