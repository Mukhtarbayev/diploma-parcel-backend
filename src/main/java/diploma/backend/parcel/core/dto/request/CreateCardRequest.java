package diploma.backend.parcel.core.dto.request;

import diploma.backend.parcel.core.enums.CardType;
import diploma.backend.parcel.core.enums.TransportType;

public record CreateCardRequest(
        Long userId,
        Integer weight,
        TransportType transportType,
        CardType cardType,
        String cityFrom,
        String cityTo,
        String arrivingTime
) {
}
