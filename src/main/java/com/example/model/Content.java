package com.example.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import jakarta.validation.constraints.NotEmpty;

public record Content(
        @Id
        Integer id,
        @NotEmpty
        String title,
        String description,
        Status status,
        Type contentType,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String url
) {
}