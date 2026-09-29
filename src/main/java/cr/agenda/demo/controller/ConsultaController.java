package cr.agenda.demo.controller;

import cr.agenda.demo.dto.consulta.ConsultaResponse;
import cr.agenda.demo.dto.consulta.CreateConsultaRequest;
import cr.agenda.demo.dto.consulta.UpdateConsultaRequest;
import cr.agenda.demo.service.IConsultaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/hospital")
@RequiredArgsConstructor
public class ConsultaController {

    private final IConsultaService consultaService;
    private final static Logger logger = LoggerFactory.getLogger(ConsultaController.class);

    @GetMapping("/consultas")
    ResponseEntity<List<ConsultaResponse>> mostrarConsultas() {
        logger.info("Mostrando consultas");
        List<ConsultaResponse> consultas = consultaService.mostrarConsultas();
        logger.info("Consultas mostradas: {}", consultas);
        return ResponseEntity.ok(consultas);
    }

    @GetMapping("/consulta/{id}")
    ResponseEntity<ConsultaResponse> mostrarConsultaById(@PathVariable Long id) {
        logger.info("Solicitud para búsqueda de consulta por id: {}", id);
        ConsultaResponse consulta = consultaService.buscarConsultaById(id);
        return ResponseEntity.ok(consulta);
    }

    @PostMapping("/consultas")
    ResponseEntity<ConsultaResponse> crearConsulta(@Valid @RequestBody CreateConsultaRequest request, UriComponentsBuilder  builder) {
        logger.info("Solicitud para crear una nueva consulta");
        ConsultaResponse consulta = consultaService.crearConsulta(request);
        URI uri = builder.path("/consultas/{id}").buildAndExpand(consulta.idConsulta()).toUri();
        logger.info("Consulta creada con éxito: {}",  consulta);
        return ResponseEntity.created(uri).body(consulta);
    }

    @PutMapping("/consulta/{id}")
    ResponseEntity<ConsultaResponse> actualizarConsulta(@Valid @RequestBody UpdateConsultaRequest request, @PathVariable Long id) {
        ConsultaResponse consulta = consultaService.buscarConsultaById(id);
        logger.info("Solicitud para actualizar una consulta: {}", consulta);
        ConsultaResponse consultaActualizada = consultaService.actualizarConsulta(id, request);
        logger.info("Consulta actualizada correctamente: {}", consultaActualizada);
        return ResponseEntity.ok(consultaActualizada);
    }





}
