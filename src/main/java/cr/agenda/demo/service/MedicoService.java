package cr.agenda.demo.service;

import cr.agenda.demo.dto.medico.CreateMedicoRequest;
import cr.agenda.demo.dto.medico.MedicoResponse;
import cr.agenda.demo.dto.medico.UpdateMedicoRequest;
import cr.agenda.demo.exception.RecursoNoEncontradoException;
import cr.agenda.demo.model.Medico;
import cr.agenda.demo.repository.MedicoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicoService implements IMedicoService {

    private final MedicoRepository medicoRepository;

    @Override
    public List<MedicoResponse> listarMedicos() {
        return medicoRepository.findAll().stream().map(MedicoResponse::new).toList();
    }

    @Override
    public MedicoResponse buscarMedicoPorId(Long id) {
        Medico medico = medicoRepository.findById(id).orElseThrow(() -> new RecursoNoEncontradoException("Medico no encontrado"));
        return new MedicoResponse(medico);
    }

    @Transactional
    @Override
    public MedicoResponse crearMedico(CreateMedicoRequest request) {
        Medico medico = new Medico(request);
        medicoRepository.save(medico);
        return new MedicoResponse(medico);
    }

    @Transactional
    @Override
    public MedicoResponse actualizarMedico(Long id, UpdateMedicoRequest request) {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException("Medico no encontrado"));
        medico.actualizarDatosMedico(request);
        return new MedicoResponse(medico);
    }

    @Override
    public void eliminarMedico(Long id) {
        Boolean medicoExiste =  medicoRepository.existsById(id);
        if (!medicoExiste)
            throw new RecursoNoEncontradoException("Medico no encontrado");
        medicoRepository.deleteById(id);
    }
}
