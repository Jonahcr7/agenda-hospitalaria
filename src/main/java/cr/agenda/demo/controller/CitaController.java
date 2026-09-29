package cr.agenda.demo.controller;

import cr.agenda.demo.dto.cita.CitaResponse;
import cr.agenda.demo.dto.cita.CreateCitaRequest;
import cr.agenda.demo.dto.cita.UpdateCitaRequest;
import cr.agenda.demo.service.ICitaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hospital")
public class CitaController {

    private final ICitaService citaService;

    @GetMapping("/citas")
    public ResponseEntity<List<CitaResponse>> listarCitas() {
        List<CitaResponse> citas = citaService.mostrarCitas();
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }

    @GetMapping("/cita/{id}")
    public ResponseEntity<CitaResponse> buscarCitaById(@PathVariable Long id) {
        CitaResponse cita = citaService.buscarCitaById(id);
        return new ResponseEntity<>(cita, HttpStatus.OK);
    }

    @PostMapping("/cita")
    public ResponseEntity<CitaResponse> crearCita(@Valid @RequestBody CreateCitaRequest request, UriComponentsBuilder builder) {
        CitaResponse cita = citaService.crearCita(request);
        URI uri = builder.path("/cita/{id}").buildAndExpand(cita.idCita()).toUri();
        return ResponseEntity.created(uri).body(cita);
    }

    @PutMapping("/cita/{id}")
    public ResponseEntity<CitaResponse> actualizarCita(@Valid @RequestBody UpdateCitaRequest request, @PathVariable Long id) {
        CitaResponse cita = citaService.actualizarCita(id, request);
        return new ResponseEntity<>(cita, HttpStatus.OK);
    }

    @DeleteMapping("cita/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarCita(@PathVariable Long id) {
        citaService.eliminarCita(id);
        Map<String, Boolean> map = new HashMap<>();
        map.put("Eliminado", Boolean.TRUE);
        return ResponseEntity.noContent().build();
    }
}
