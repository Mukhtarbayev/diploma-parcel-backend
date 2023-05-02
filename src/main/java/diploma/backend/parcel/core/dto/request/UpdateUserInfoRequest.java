package diploma.backend.parcel.core.dto.request;

import jakarta.annotation.Nullable;

public record UpdateUserInfoRequest(
        Long id,
        @Nullable String firstName,
        @Nullable String lastName,
        @Nullable String phoneNumber
) {
}
