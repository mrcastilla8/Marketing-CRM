package pe.unmsm.crm.marketing.leads.domain.model.staging;

import lombok.Data;
import java.util.Map;

@Data
public class EnvioFormulario {
    private Long id;
    private Long formularioId;
    private Map<String, String> respuestas;
}