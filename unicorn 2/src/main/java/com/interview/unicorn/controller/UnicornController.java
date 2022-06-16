package com.interview.unicorn.controller;

import com.interview.unicorn.domain.UnicornDetails;
import com.interview.unicorn.service.UnicornService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/unicorns")
public class UnicornController {

    private final UnicornService unicornService;

    public UnicornController(UnicornService unicornService) {
        this.unicornService = unicornService;
    }

    @GetMapping("/{unicornId}")
    public ResponseEntity getUnicornDetailsById(@PathVariable Integer unicornId) {
        UnicornDetails unicornDetails = unicornService.getUnicornById(unicornId);
        return ResponseEntity.ok(unicornDetails);
    }

    @GetMapping
    public ResponseEntity getAllUnicornDetails() {
        List<UnicornDetails> unicornDetails = unicornService.getAllUnicorns();
        return ResponseEntity.ok(unicornDetails);
    }

    @PostMapping
    public ResponseEntity storeDetails(@RequestBody UnicornDetails unicornDetails) {
        Integer unicornId = unicornService.saveUnicornDetails(unicornDetails);
        Map<String, Integer> body = new LinkedHashMap<>();
        body.put("unicornId",unicornId);
        return ResponseEntity.ok(body);
    }

    @PutMapping("/{unicornId}")
    public ResponseEntity updateDetails(@PathVariable Integer unicornId, @RequestBody UnicornDetails unicornDetails) {
        unicornService.updateUnicornDetails(unicornId, unicornDetails);
        Map<String, Integer> body = new LinkedHashMap<>();
        body.put("Unicorn details are updated for unicorn id",unicornId);
        return ResponseEntity.ok(body);
    }
}
