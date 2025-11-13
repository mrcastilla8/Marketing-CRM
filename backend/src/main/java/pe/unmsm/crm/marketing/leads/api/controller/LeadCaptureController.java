package pe.unmsm.crm.marketing.leads.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.Map;

import pe.unmsm.crm.marketing.leads.application.service.LeadProcessingService;
import pe.unmsm.crm.marketing.leads.application.service.LeadCaptureService; // Nuevo servicio necesario
import pe.unmsm.crm.marketing.leads.domain.model.staging.EnvioFormulario;
import pe.unmsm.crm.marketing.leads.domain.enums.TipoFuente;

@RestController
@RequestMapping("/api/v1/leads/capture")
@RequiredArgsConstructor
public class LeadCaptureController {
    
    private final LeadProcessingService processingService;
    private final LeadCaptureService captureService;

    @PostMapping("/web")
    public ResponseEntity<Void> recibirFormulario(@RequestBody Map<String, String> payload) {
        
        EnvioFormulario envioGuardado = captureService.guardarEnvioWeb(payload);

        processingService.procesarDesdeStaging(TipoFuente.WEB, envioGuardado);
        
        return ResponseEntity.accepted().build();
    }
}