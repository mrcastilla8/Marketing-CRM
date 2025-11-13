package pe.unmsm.crm.marketing.leads.domain.factory;

import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper; // Dependencia Jackson para leer JSON
import java.util.Map;

import pe.unmsm.crm.marketing.leads.domain.model.Lead;
import pe.unmsm.crm.marketing.leads.domain.model.LeadImportado;
import pe.unmsm.crm.marketing.leads.domain.model.staging.RegistroImportado;
import pe.unmsm.crm.marketing.leads.domain.enums.TipoFuente;
import pe.unmsm.crm.marketing.leads.domain.enums.EstadoLead;
import pe.unmsm.crm.marketing.leads.domain.vo.DatosContacto;
import pe.unmsm.crm.marketing.leads.domain.vo.DatosDemograficos;
import pe.unmsm.crm.marketing.leads.domain.vo.TrackingUTM;

@Component
public class ImportLeadFactory implements LeadFactory {

    // Herramienta para convertir el String JSON de la DB a un Mapa usable
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Lead convertirALead(Object origenStaging) {
        // 1. Validación de tipo
        if (!(origenStaging instanceof RegistroImportado)) {
            throw new IllegalArgumentException("El objeto origen no es un RegistroImportado");
        }
        RegistroImportado registro = (RegistroImportado) origenStaging;

        try {
            // 2. Parsear el JSON crudo que vino del Excel
            // Ejemplo JSON: {"nombre": "Juan", "email": "juan@test.com", "edad": "30"}
            @SuppressWarnings("unchecked")
            Map<String, Object> datos = objectMapper.readValue(registro.getDatosJson(), Map.class);

            // 3. Crear la instancia concreta
            LeadImportado lead = new LeadImportado();
            lead.setNombre(String.valueOf(datos.getOrDefault("nombre", "Sin Nombre")));
            lead.setIdReferenciaOrigen(registro.getId());
            lead.setEstado(EstadoLead.NUEVO); // Siempre nacen nuevos

            // 4. Construir VO: Datos de Contacto (Obligatorio)
            DatosContacto contacto = new DatosContacto(
                String.valueOf(datos.get("email")),
                String.valueOf(datos.getOrDefault("telefono", "")),
                null // El Excel raramente trae ID de distrito validado
            );
            lead.setContacto(contacto);

            // 5. Construir VO: Datos Demográficos (Opcional)
            if (datos.containsKey("edad") || datos.containsKey("genero")) {
                Integer edad = parseIntSafe(datos.get("edad"));
                String genero = (String) datos.get("genero");
                lead.setDemograficos(new DatosDemograficos(edad, genero, null));
            }

            TrackingUTM tracking = new TrackingUTM(
                "IMPORTACION",                 
                "ARCHIVO_EXCEL",               
                "LOTE_" + registro.getLoteId()
            );
            lead.setTracking(tracking);

            return lead;

        } catch (Exception e) {
            throw new RuntimeException("Error al procesar datos de importación: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean soporta(TipoFuente tipo) {
        return TipoFuente.IMPORTACION.equals(tipo);
    }

    private Integer parseIntSafe(Object value) {
        if (value == null) return null;
        try {
            return Integer.parseInt(String.valueOf(value));
        } catch (NumberFormatException e) {
            return null;
        }
    }
}