package pe.unmsm.crm.marketing.leads.domain.repository;

import pe.unmsm.crm.marketing.leads.domain.model.staging.EnvioFormulario;
import pe.unmsm.crm.marketing.leads.domain.model.staging.RegistroImportado;
import java.util.Optional;

public interface StagingRepository {
    Optional<EnvioFormulario> findEnvioById(Long id);

    Optional<RegistroImportado> findRegistroById(Long id);
}