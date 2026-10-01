package cr.agenda.demo.service;

import cr.agenda.demo.dto.medico.CreateMedicoRequest;
import cr.agenda.demo.dto.medico.MedicoResponse;
import cr.agenda.demo.dto.medico.UpdateMedicoRequest;
import cr.agenda.demo.model.Medico;

import java.util.List;

public interface IMedicoService {

    public List<MedicoResponse> listarMedicos();

    public List<MedicoResponse> listarMedicosActivos();

    public List<MedicoResponse> listarMedicosInactivos();

    public MedicoResponse buscarMedicoPorId(Long id);

    public MedicoResponse crearMedico(CreateMedicoRequest request);

    public MedicoResponse actualizarMedico(Long id, UpdateMedicoRequest request);

    public void eliminarMedico(Long id);
}
