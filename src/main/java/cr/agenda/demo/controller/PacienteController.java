package cr.agenda.demo.controller;

import cr.agenda.demo.dto.paciente.CreatePacienteRequest;
import cr.agenda.demo.dto.paciente.PacienteResponse;
import cr.agenda.demo.dto.paciente.UpdatePacienteRequest;
import cr.agenda.demo.service.IPacienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class PacienteController {

    private final IPacienteService pacienteService;
    private final static Logger logger = LoggerFactory.getLogger(PacienteController.class);

    @GetMapping("/pacientes")
    public ResponseEntity<List<PacienteResponse>> listarPacientes(){
        logger.info("Listando pacientes...");
        List<PacienteResponse> pacientes = pacienteService.listarPacientes();
        logger.info("Pacientes listado: {}", pacientes);
        return ResponseEntity.ok(pacientes);
    }

    @PostMapping("/paciente")
    public ResponseEntity<PacienteResponse> crearPaciente(@RequestBody @Valid CreatePacienteRequest request, UriComponentsBuilder uriBuilder) {
        logger.info("Solicitud para crear un paciente: {}", request);
        PacienteResponse nuevoPaciente = pacienteService.crearPaciente(request);
        URI uri = uriBuilder.path("pacientes/{id}").buildAndExpand(nuevoPaciente.id()).toUri();
        logger.info("Paciente creado: {}", nuevoPaciente);
        return ResponseEntity.created(uri).body(nuevoPaciente);
    }

    @GetMapping("paciente/{id}")
    public ResponseEntity<PacienteResponse> buscarPacientePorId(@PathVariable Long id){
        logger.info("Buscando paciente por id: {}", id);
        PacienteResponse paciente = pacienteService.buscarPacientePorId(id);
        logger.info("Paciente buscado: {}", paciente);
        return new ResponseEntity<>(paciente, HttpStatus.OK);
    }

    @PutMapping("/paciente/{id}")
    public ResponseEntity<PacienteResponse> actualizarPaciente(@PathVariable Long id, @RequestBody @Valid UpdatePacienteRequest request) {
        logger.info("Actualizando paciente por id: {}", id);
        PacienteResponse paciente = pacienteService.actualizarPaciente(id, request);
        logger.info("Paciente actualizado: {}", paciente);
        return ResponseEntity.ok(paciente);
    }

    @DeleteMapping("paciente/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarPaciente(@PathVariable Long id){
        logger.info("Eliminando paciente por id: {}", id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Paciente eliminado", Boolean.TRUE);
        return ResponseEntity.noContent().build();
    }
}
