package cinema.controller;

import cinema.dto.ReturnRequestDTO;
import cinema.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class that handles ticket return requests.
 * Provides REST endpoints for returning seats in the cinema.
 */

@RestController
public class ReturnController {
    private final PurchaseService purchaseService;

    /**
     * Autowired constructor to inject the PurchaseService.
     *
     * @param purchaseService the service that handles purchase logic.
     */
    @Autowired
    public ReturnController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping("/return")
    public ResponseEntity<?> returnTicket(@RequestBody ReturnRequestDTO requestDTO) {
        return purchaseService.returnTicket(requestDTO.getToken());
    }
}
