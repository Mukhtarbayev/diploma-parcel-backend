package diploma.backend.parcel.core.dto.request;

import jakarta.annotation.Nullable;

import java.time.LocalDateTime;

public record FilterRequest(
    @Nullable String from,
    @Nullable String to,
    @Nullable LocalDateTime when
) {}
