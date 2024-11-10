package com.reservas.reservassalon.service;

import com.reservas.reservassalon.model.Salon;
import com.reservas.reservassalon.repository.SalonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalonService {
    
    @Autowired
    private SalonRepository salonRepository;

    public Salon create(Salon salon) {
        return salonRepository.save(salon);
    }

    public List<Salon> getAllSalon() {
        return salonRepository.findAll();
    }

    public void deleteById(String id) {
        salonRepository.deleteById(id);
    }

    public Optional<Salon> findById(String id) {
        return salonRepository.findById(id);
    }

    public boolean existsById(String id) {
        return salonRepository.existsById(id);
    }
    public boolean notExistsById(String id) {
        return !salonRepository.existsById(id);
    }
}
