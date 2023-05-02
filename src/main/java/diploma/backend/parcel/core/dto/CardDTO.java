package diploma.backend.parcel.core.dto;

import diploma.backend.parcel.core.enums.CardType;
import diploma.backend.parcel.core.enums.TransportType;

import java.time.LocalDateTime;

public record CardDTO(
        Long id,
        Long userId,
        Integer weight,
        TransportType transport,
        CardType type,
        String cityFrom,
        String cityTo,
        LocalDateTime arrivingTime,
        LocalDateTime updatedTime,
        String userName,
        String phoneNumber
) {}