package pe.unmsm.crm.marketing.leads.domain.model;

import pe.unmsm.crm.marketing.leads.domain.enums.TipoFuente;

public class LeadWeb extends Lead {
    public LeadWeb() {
        super();
        this.fuenteTipo = TipoFuente.WEB;
    }

    @Override
    public String getResumenOrigen() {
        return "Web Ref#" + this.idReferenciaOrigen;
    }
}