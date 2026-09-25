package cr.agenda.demo.model;

import cr.agenda.demo.dto.cita.CreateCitaRequest;
import cr.agenda.demo.dto.cita.UpdateCitaRequest;
import cr.agenda.demo.model.enums.Estado;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "cita")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cita {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado", nullable = false, length = 20)
    private Estado estado;

    @Column(name = "motivo_consulta", nullable = false, length = 255)
    private String motivoConsulta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_medico", nullable = false)
    private Medico medico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_paciente", nullable = false)
    private Paciente paciente;

    public Cita (CreateCitaRequest request, Medico medico, Paciente paciente) {
        this.fechaHora = LocalDateTime.now();
        this.estado = request.estado();
        this.motivoConsulta = request.motivoConsulta();
        this.medico = medico;
        this.paciente = paciente;
    }

    public void actualizarCita(UpdateCitaRequest request, Medico medico) {
        this.estado = request.estado();
        this.motivoConsulta = request.motivoConsulta();
        this.medico = medico;
    }
}
