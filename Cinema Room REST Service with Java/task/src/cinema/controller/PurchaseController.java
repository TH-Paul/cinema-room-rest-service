package cinema.controller;

import cinema.dto.PurchaseRequestDTO;
import cinema.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class that handles ticket purchase requests.
 * Provides REST endpoints for purchasing seats in the cinema.
 */
@RestController
public class PurchaseController {
    private final PurchaseService purchaseService;

    /**
     * Autowired constructor to inject the PurchaseService.
     *
     * @param purchaseService the service that handles ticket purchase logic.
     */
    @Autowired
    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    /**
     * Endpoint to handle seat purchase.
     *
     * @param requestDTO the request object containing the seat's row and column information.
     * @return ResponseEntity containing the purchase details or an error message.
     */
    @PostMapping("/purchase")
    public ResponseEntity<?> purchaseTicket(@RequestBody PurchaseRequestDTO requestDTO) {
        return purchaseService.purchaseSeat(requestDTO);
    }
}
