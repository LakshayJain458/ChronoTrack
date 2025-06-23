package org.example.tt_backened.DTO;

public record ErrorResponseDto(
        int statusCode,
        String message,
        String details
) {
}
