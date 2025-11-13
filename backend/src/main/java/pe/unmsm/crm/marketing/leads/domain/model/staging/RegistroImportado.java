package pe.unmsm.crm.marketing.leads.domain.model.staging;

import lombok.Data;

@Data
public class RegistroImportado {
    private Long id;
    private Long loteId;
    private String datosJson;
    private int numeroFila;
}