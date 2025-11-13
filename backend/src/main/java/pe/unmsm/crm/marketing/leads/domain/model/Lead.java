package pe.unmsm.crm.marketing.leads.domain.model;

import java.util.UUID;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import pe.unmsm.crm.marketing.leads.domain.vo.DatosContacto;
import pe.unmsm.crm.marketing.leads.domain.vo.DatosDemograficos;
import pe.unmsm.crm.marketing.leads.domain.vo.TrackingUTM;
import pe.unmsm.crm.marketing.leads.domain.enums.EstadoLead;
import pe.unmsm.crm.marketing.leads.domain.enums.TipoFuente;

@Getter @Setter
public abstract class Lead {
    protected UUID id;
    protected String nombre;
    protected LocalDateTime fechaCreacion;
    protected EstadoLead estado;
    
    protected DatosContacto contacto;
    protected DatosDemograficos demograficos; 
    protected TrackingUTM tracking;          

    protected TipoFuente fuenteTipo;
    protected Long idReferenciaOrigen;

    public Lead() {
        this.id = UUID.randomUUID();
        this.fechaCreacion = LocalDateTime.now();
        this.estado = EstadoLead.NUEVO;
    }

    public abstract String getResumenOrigen();
}