package co.com.poli.profesores.repository;

import co.com.poli.profesores.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, String> {

    boolean existsById(String id);
    void deleteById(String identificacion);
}
