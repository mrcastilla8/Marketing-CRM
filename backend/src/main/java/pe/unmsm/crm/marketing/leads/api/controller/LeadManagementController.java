@RestController
@RequestMapping("/api/v1/leads/gestion")
@RequiredArgsConstructor
public class LeadManagementController {

    private final LeadManagementService managementService;

    @PatchMapping("/{id}/estado")
    public ResponseEntity<Void> cambiarEstado(@PathVariable UUID id, @RequestParam EstadoLead estado) {
        managementService.cualificarLead(id, estado);
        return ResponseEntity.ok().build();
    }
}