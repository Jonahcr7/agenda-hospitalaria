package cr.agenda.demo.dto.error;

import java.time.LocalDateTime;

public record ErrorResponse(
        int status,
        String error,
        String mensaje,
        LocalDateTime timestamp
) {
    public ErrorResponse(int status, String error, String mensaje) {
        this(status, error, mensaje, LocalDateTime.now());
    }

}
