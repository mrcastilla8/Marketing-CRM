package pe.unmsm.crm.marketing.leads.domain.factory;

import pe.unmsm.crm.marketing.leads.domain.model.Lead;
import pe.unmsm.crm.marketing.leads.domain.enums.TipoFuente;

public interface LeadFactory {
    // Método Factory: Convierte el dato sucio en Lead limpio
    Lead convertirALead(Object origenStaging);

    // Método Selector: Evita los IFs en el servicio
    boolean soporta(TipoFuente tipo);
}