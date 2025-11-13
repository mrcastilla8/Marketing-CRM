package pe.unmsm.crm.marketing.leads.domain.model;

import pe.unmsm.crm.marketing.leads.domain.enums.TipoFuente;

public class LeadImportado extends Lead {
    public LeadImportado() {
        super();
        this.fuenteTipo = TipoFuente.IMPORTACION;
    }

    @Override
    public String getResumenOrigen() {
        return "Importación Ref#" + this.idReferenciaOrigen;
    }
}