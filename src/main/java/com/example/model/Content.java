package com.example.model;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotEmpty;

public record Content(
        Integer id,
        @NotEmpty
        String title,
        String desc,
        Status status,
        Type contentType,
        LocalDateTime dateCreated,
        LocalDateTime dateUpdated,
        String url
) {
}