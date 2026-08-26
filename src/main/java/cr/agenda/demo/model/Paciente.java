package cr.agenda.demo.model;

import cr.agenda.demo.model.enums.Especialidad;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Paciente")
@Table(name = "paciente")
public class Paciente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPaciente;
    private String nombrePaciente;
    private String apellidoPaciente;
    private String emailPaciente;
    private String telefonoPaciente;
    private String fechaNacPaciente;
    private String documentoIdentidadPaciente;
    private Especialidad especialidad;
    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Cita> citas = new ArrayList<>();
}
