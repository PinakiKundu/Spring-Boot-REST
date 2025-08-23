package com.pinakis.spring;

import org.springframework.web.bind.annotation.*;
import java.time.Instant;

@RestController
@RequestMapping("/")
public class RestApiController {

    private final Processor processor;

    public RestApiController(Processor processor) {
        this.processor = processor;
    }

    @GetMapping("/")
    public String homePage() {
        return """
            <html>
              <head><title>Spring-Boot-REST</title></head>
              <body style='font-family: Arial, sans-serif;'>
                <h1>Welcome to Spring-Boot-REST</h1>
                <p>Available APIs:</p>
                <ul>
                  <li><b>/health</b> - Application health check</li>
                  <li><b>/status/{assetId}</b> - Get asset status by ID</li>
                  <li><b>/actuator</b> - Spring Boot Actuator endpoints</li>
                </ul>
              </body>
            </html>
            """;
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "OK";
    }

    @GetMapping("/status/{assetId}")
    public AssetStatus getState(@PathVariable Long assetId) {
        State state = switch (assetId.intValue()) {
            case 1 -> State.DRAFT;
            case 2 -> State.PUBLISHED;
            default -> State.UNKNOWN;
        };

        return new AssetStatus(
                assetId,
                state,
                Instant.now(),
                Instant.now()
        );
    }
}
