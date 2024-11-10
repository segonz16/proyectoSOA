package co.com.poli.profesores.service;

import co.com.poli.profesores.model.Profesor;
import co.com.poli.profesores.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {

    @Autowired
    private ProfesorRepository profesorRepository;

    public Profesor create(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    public List<Profesor> getAllProfesor() {
        return profesorRepository.findAll();
    }

    public void deleteById(String id) {
        profesorRepository.deleteById(id);
    }

    public Optional<Profesor> findById(String id) {
        return profesorRepository.findById(id);
    }

    public boolean existsById(String id) {
        return profesorRepository.existsById(id);
    }
    public boolean notExistsById(String id) {
        return !profesorRepository.existsById(id);
    }
}
