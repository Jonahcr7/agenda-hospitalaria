package cr.agenda.demo.controller;

import cr.agenda.demo.dto.medico.CreateMedicoRequest;
import cr.agenda.demo.dto.medico.MedicoResponse;
import cr.agenda.demo.dto.medico.UpdateMedicoRequest;
import cr.agenda.demo.service.IMedicoService;
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
@RequestMapping("/hospital")
@RequiredArgsConstructor
public class MedicoController {

    public static final Logger logger = LoggerFactory.getLogger(MedicoController.class);
    private final IMedicoService medicoService;

    @GetMapping("/medicos")
    public ResponseEntity<List<MedicoResponse>> listarMedicos() {
        List<MedicoResponse> medicos = medicoService.listarMedicos();
        return new ResponseEntity<>(medicos, HttpStatus.OK);
    }

    @GetMapping("/medico/{id}")
    public ResponseEntity<MedicoResponse> buscarMedicoPorId(@PathVariable Long id) {
        MedicoResponse medico = medicoService.buscarMedicoPorId(id);
        return new ResponseEntity<>(medico, HttpStatus.OK);
    }

    @PostMapping("/medico")
    public ResponseEntity<MedicoResponse> nuevoMedico(@RequestBody @Valid CreateMedicoRequest datos, UriComponentsBuilder uri) {
        MedicoResponse nuevoMedico = medicoService.crearMedico(datos);
        URI url = uri.path("/medicos/{cedula}").buildAndExpand(nuevoMedico.cedula()).toUri();
        logger.info("Nueva Medico: {}", nuevoMedico);
        return ResponseEntity.created(url).body(nuevoMedico);
    }

    @PutMapping("/medico/{id}")
    public ResponseEntity<MedicoResponse> actualizarMedico(@RequestBody @Valid UpdateMedicoRequest datos, @PathVariable Long id) {
        MedicoResponse medico = medicoService.actualizarMedico(id, datos);
        return new ResponseEntity<>(medico, HttpStatus.OK);
    }

    @DeleteMapping("/medico/{id}")
    public ResponseEntity<Map<String, Boolean>> eliminarMedico(@PathVariable Long id) {
        medicoService.eliminarMedico(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Eliminado", Boolean.TRUE);
        return ResponseEntity.noContent().build();
    }
}
