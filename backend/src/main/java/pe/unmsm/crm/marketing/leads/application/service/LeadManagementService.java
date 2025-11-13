package pe.unmsm.crm.marketing.leads.application.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.UUID;
import pe.unmsm.crm.marketing.leads.domain.model.Lead;
import pe.unmsm.crm.marketing.leads.domain.enums.EstadoLead;
import pe.unmsm.crm.marketing.leads.domain.repository.LeadRepository;

@Service
@RequiredArgsConstructor
public class LeadManagementService {

    private final LeadRepository leadRepository;

    public void cualificarLead(UUID leadId, EstadoLead nuevoEstado) {
        Lead lead = leadRepository.findById(leadId)
            .orElseThrow(() -> new RuntimeException("Lead no encontrado"));

        // Validación simple
        if (lead.getEstado() == EstadoLead.DESCARTADO && nuevoEstado == EstadoLead.NUEVO) {
            throw new IllegalStateException("No se puede reactivar un lead descartado");
        }

        // El estado máximo al que llegamos es CALIFICADO
        lead.setEstado(nuevoEstado);
        leadRepository.save(lead);
    }
}