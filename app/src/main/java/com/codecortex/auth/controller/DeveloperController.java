package com.codecortex.auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DeveloperController {

    @GetMapping("/api/v1/developer")
    public ResponseEntity<Map<String, Object>> developerDetails() {

        Map<String, Object> response = Map.of(
                "developer", "Roshan Jaiswal (Codecortex)",
                "contact", Map.of(
                        "linkedin", "https://www.linkedin.com/in/codecortex/",
                        "instagram", "https://www.instagram.com/codecortexx/",
                        "github", "https://github.com/CodeCortex"
                )
        );

        return ResponseEntity.ok(response);
    }
}