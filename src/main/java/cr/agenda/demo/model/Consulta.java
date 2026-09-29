package cr.agenda.demo.model;

import cr.agenda.demo.dto.cita.CreateCitaRequest;
import cr.agenda.demo.dto.consulta.CreateConsultaRequest;
import cr.agenda.demo.dto.consulta.UpdateConsultaRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "consulta")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_hora_de_atencion", nullable = false)
    private LocalDateTime fechaHoraDeAtencion;

    @Column(name = "sintomas", nullable = false, columnDefinition = "TEXT")
    private String sintomas;

    @Column(name = "diagnostico", nullable = false, columnDefinition = "TEXT")
    private String diagnostico;

    @Column(name = "tratamiento", columnDefinition = "TEXT")
    private String tratamiento;

    @Column(name = "observaciones", columnDefinition = "TEXT")
    private String observaciones;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cita", nullable = false, unique = true)
    private Cita cita;

    public Consulta(CreateConsultaRequest request, Cita cita) {
        this.fechaHoraDeAtencion = request.fechaHoraDeAtencion();
        this.sintomas = request.sintomas();
        this.diagnostico = request.diagnostico();
        this.tratamiento = request.tratamiento();
        this.observaciones = request.observaciones();
        this.cita = cita;
    }

    public void actualizarConsulta(UpdateConsultaRequest request) {
        this.sintomas = request.sintomas();
        this.diagnostico = request.diagnostico();
        this.tratamiento = request.tratamiento();
        this.observaciones = request.observaciones();
    }
}
