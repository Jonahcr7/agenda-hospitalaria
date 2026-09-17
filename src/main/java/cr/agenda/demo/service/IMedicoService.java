package cr.agenda.demo.service;

import cr.agenda.demo.dto.medico.CreateMedicoRequest;
import cr.agenda.demo.dto.medico.MedicoResponse;
import cr.agenda.demo.dto.medico.UpdateMedicoRequest;

import java.util.List;

public interface IMedicoService {

    public List<MedicoResponse> listarMedicos();

    public MedicoResponse buscarMedicoPorId(Long id);

    public MedicoResponse crearMedico(CreateMedicoRequest request);

    public MedicoResponse actualizarMedico(Long id, UpdateMedicoRequest request);

    public void eliminarMedico(Long id);
}
