package com.reservas.reservassalon.rest;

import com.reservas.reservassalon.model.Salon;
import com.reservas.reservassalon.service.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/salones")
public class SalonREST {

    @Autowired
    SalonService salonService;

    @PostMapping(value = "/guardar")
    private ResponseEntity<Salon> guardar(@RequestBody Salon salon) {

        try {
            if (salonService.notExistsById(salon.getCodigoSalon())) {
                Salon temporal = salonService.create(salon);
                return ResponseEntity.created(new URI("/api/salones/guardar" + temporal.getCodigoSalon())).body(temporal);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "/salones")
    private ResponseEntity<List<Salon>> ListarTodosLosSalones() {
        return ResponseEntity.ok(salonService.getAllSalon());
    }

    @GetMapping("/salones/{id}")
    private ResponseEntity<Optional<Salon>> ListarSalonesPorId(@PathVariable String id) {
        return ResponseEntity.ok(salonService.findById(id));
    }

    @DeleteMapping("/eliminarsalon/{id}")
    public ResponseEntity<String> eliminarSalonById(@PathVariable String id) {
        if (salonService.existsById(id)) {
            salonService.deleteById(id);
            return ResponseEntity.ok("salon deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/salon/actualizar")
    private ResponseEntity<Salon> actualizarSalon(@RequestBody Salon salon) {
        try {
            if (salonService.existsById(salon.getCodigoSalon())) {
                Salon temp = salonService.create(salon);

                return new ResponseEntity<>(salon,HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }


}
