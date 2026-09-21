package cr.agenda.demo.controller;

import cr.agenda.demo.dto.paciente.CreatePacienteRequest;
import cr.agenda.demo.dto.paciente.PacienteResponse;
import cr.agenda.demo.service.IPacienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hospital")
public class PacienteController {

    private final IPacienteService pacienteService;
    private final static Logger logger = LoggerFactory.getLogger(PacienteController.class);

    @GetMapping("/pacientes")
    public ResponseEntity<List<PacienteResponse>> listarPacientes(){
        List<PacienteResponse> pacientes = pacienteService.listarPacientes();
        return ResponseEntity.ok(pacientes);
    }

    @PostMapping("/paciente")
    public ResponseEntity<PacienteResponse> crearPaciente(@RequestBody @Valid CreatePacienteRequest request) {
        PacienteResponse nuevoPaciente = pacienteService.crearPaciente(request);
        return ResponseEntity.ok(nuevoPaciente);
    }
}
