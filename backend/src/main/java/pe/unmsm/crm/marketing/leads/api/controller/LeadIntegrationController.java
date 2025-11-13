package pe.unmsm.crm.marketing.leads.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/internal/leads")
@RequiredArgsConstructor
public class LeadIntegrationController {


    @GetMapping("/qualified")
    public ResponseEntity<List<Object>> obtenerLeadsCalificados(
            @RequestParam LocalDate fechaDesde,
            @RequestParam LocalDate fechaHasta) {
        
        return ResponseEntity.ok().build(); // Placeholder
    }
}