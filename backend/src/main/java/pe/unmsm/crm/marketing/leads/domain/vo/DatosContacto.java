package pe.unmsm.crm.marketing.leads.domain.vo;

import lombok.Value; // Inmutable

@Value
public class DatosContacto {
    String email;
    String telefono;
}