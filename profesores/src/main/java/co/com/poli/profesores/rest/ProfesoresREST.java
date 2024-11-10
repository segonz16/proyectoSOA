package co.com.poli.profesores.rest;

import co.com.poli.profesores.model.Profesor;
import co.com.poli.profesores.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profesores")
public class ProfesoresREST {

    @Autowired
    ProfesorService profesorService;

    @PostMapping(value = "/guardar")
    private ResponseEntity<Profesor> guardar(@RequestBody Profesor profesor) {

        try {
            if (profesorService.notExistsById(profesor.getDocumento())) {
                Profesor temporal = profesorService.create(profesor);
                return ResponseEntity.created(new URI("/api/profesores/guardar" + temporal.getDocumento())).body(temporal);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "/profesores")
    private ResponseEntity<List<Profesor>> ListarTodosLosProfesores() {
        return ResponseEntity.ok(profesorService.getAllProfesor());
    }

    @GetMapping("/profesores/{id}")
    private ResponseEntity<Optional<Profesor>> ListarProfesorPorId(@PathVariable String id) {
        return ResponseEntity.ok(profesorService.findById(id));
    }

    @DeleteMapping("/eliminarprofesor/{id}")
    public ResponseEntity<String> eliminarProfesorById(@PathVariable String id) {
        if (profesorService.existsById(id)) {
            profesorService.deleteById(id);
            return ResponseEntity.ok("profesor deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/profesor/actualizar")
    private ResponseEntity<Profesor> actualizarProfesor(@RequestBody Profesor profesor) {
        try {
            if (profesorService.existsById(profesor.getDocumento())) {
                Profesor temp = profesorService.create(profesor);

                return new ResponseEntity<>(profesor,HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }

}
