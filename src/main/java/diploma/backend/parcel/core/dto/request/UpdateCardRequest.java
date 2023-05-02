package diploma.backend.parcel.core.dto.request;

import diploma.backend.parcel.core.enums.CardType;
import diploma.backend.parcel.core.enums.TransportType;
import jakarta.annotation.Nullable;

import java.time.LocalDateTime;

public record UpdateCardRequest(
        Long id,
        @Nullable Integer weight,
        @Nullable TransportType transportType,
        @Nullable CardType cardType,
        @Nullable String cityFrom,
        @Nullable String cityTo,
        @Nullable LocalDateTime arrivingTime
) {
}
