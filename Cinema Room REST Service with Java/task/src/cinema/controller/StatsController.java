package cinema.controller;

import cinema.dto.ErrorDTO;
import cinema.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller class that handles statistics requests for the cinema room.
 */
@RestController
public class StatsController {
    private final StatsService statsService;

    /**
     * Autowired constructor to inject the StatsService.
     *
     * @param statsService the service that handles statistics calculation.
     */
    @Autowired
    public StatsController(StatsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping("/stats")
    public ResponseEntity<?> getStatistics(@RequestParam(value = "password", required = false) String password) {
        if (password == null || !password.equals("super_secret")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ErrorDTO("The password is wrong!"));
        }

        StatsService.Statistics stats = statsService.getStatistics();
        return ResponseEntity.status(HttpStatus.OK).body(stats);
    }
}
