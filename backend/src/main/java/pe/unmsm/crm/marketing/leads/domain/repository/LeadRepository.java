package pe.unmsm.crm.marketing.leads.domain.repository;

import pe.unmsm.crm.marketing.leads.domain.model.Lead;
import java.util.Optional;
import java.util.UUID;

public interface LeadRepository {
    void save(Lead lead);
    Optional<Lead> findById(UUID id);
}