package pe.unmsm.crm.marketing.leads.application.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.util.List;

import pe.unmsm.crm.marketing.leads.domain.factory.LeadFactory;
import pe.unmsm.crm.marketing.leads.domain.model.Lead;
import pe.unmsm.crm.marketing.leads.domain.enums.TipoFuente;
import pe.unmsm.crm.marketing.leads.domain.repository.LeadRepository;

@Service
@RequiredArgsConstructor
public class LeadProcessingService {

    // Spring inyecta TODAS las fábricas en esta lista
    private final List<LeadFactory> factories;
    private final LeadRepository leadRepository;

    public void procesarDesdeStaging(TipoFuente tipo, Object datoStaging) {
        
        // 1. Seleccionar Estrategia (Factory) dinámicamente
        LeadFactory factory = factories.stream()
                .filter(f -> f.soporta(tipo))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("No existe fábrica para: " + tipo));

        // 2. Convertir Staging -> Lead (El Lead nace NUEVO)
        Lead nuevoLead = factory.convertirALead(datoStaging);

        // 3. Guardar
        leadRepository.save(nuevoLead);
    }
}