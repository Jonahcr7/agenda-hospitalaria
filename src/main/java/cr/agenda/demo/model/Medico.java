package cr.agenda.demo.model;

import cr.agenda.demo.dto.medico.CreateMedicoRequest;
import cr.agenda.demo.dto.medico.UpdateMedicoRequest;
import cr.agenda.demo.model.enums.Especialidad;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "medico")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "apellido", nullable = false, length = 100)
    private String apellido;

    @Column(name = "cedula", nullable = false, unique = true, length = 50)
    private String cedula;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "telefono", length = 20)
    private String telefono;

    @Enumerated(EnumType.STRING)
    @Column(name = "especialidad", nullable = false, length = 50)
    private Especialidad especialidad;

    @Column(name = "activo", nullable = false)
    private boolean activo = true;

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Cita> citas = new ArrayList<>();

    public Medico (CreateMedicoRequest request) {
        this.nombre = request.nombre();
        this.apellido = request.apellido();
        this.cedula = request.cedula();
        this.email = request.email();
        this.telefono = request.telefono();
        this.especialidad = request.especialidad();
    }

    public void actualizarDatosMedico(UpdateMedicoRequest request) {
        this.nombre = request.nombre();
        this.apellido = request.apellido();
        this.email = request.email();
        this.telefono = request.telefono();
        this.especialidad = request.especialidad();
    }


}

