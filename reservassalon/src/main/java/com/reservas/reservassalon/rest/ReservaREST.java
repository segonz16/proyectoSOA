package com.reservas.reservassalon.rest;

import com.reservas.reservassalon.model.Reserva;
import com.reservas.reservassalon.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/gestionreserva")
public class ReservaREST {

    @Autowired
    ReservaService reservaService;

    @PostMapping(value = "/guardar")
    private ResponseEntity<Reserva> guardar(@RequestBody Reserva reserva) {

        try {
            if (reservaService.notExistsById(reserva.getId())) {
                Reserva temporal = reservaService.create(reserva);
                return ResponseEntity.created(new URI("/api/gestionreserva/guardar" + temporal.getId())).body(temporal);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping(value = "/reservas")
    private ResponseEntity<List<Reserva>> ListarTodasLasReservas() {
        return ResponseEntity.ok(reservaService.getAllResevas());
    }

    @GetMapping("/reservas/{id}")
    private ResponseEntity<Optional<Reserva>> ListarReservaPorId(@PathVariable int id) {
        return ResponseEntity.ok(reservaService.findById(id));
    }

    @GetMapping("/reservas/codigoSalon/{codigoSalon}")
    private ResponseEntity<List<Reserva>> ListarReservaPorCodigoSalon(@PathVariable String codigoSalon) {
        return ResponseEntity.ok(reservaService.findByCodigoSalon(codigoSalon));
    }

    @GetMapping("/reservas/idProfesor/{idProfesor}")
    private ResponseEntity<List<Reserva>> ListarReservaPorIdProfesor(@PathVariable String idProfesor) {
        return ResponseEntity.ok(reservaService.findByIdProfesor(idProfesor));
    }

    @DeleteMapping("/eliminarreserva/{id}")
    public ResponseEntity<String> eliminarReservaById(@PathVariable int id) {
        if (reservaService.existsById(id)) {
            reservaService.deleteById(id);
            return ResponseEntity.ok("reserva deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping(value = "/reservas/actualizar")
    private ResponseEntity<Reserva> actualizarReserva(@RequestBody Reserva reserva) {
        try {
            if (reservaService.existsById(reserva.getId())) {
                Reserva temp = reservaService.create(reserva);

                return new ResponseEntity<>(reserva, HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }


}
