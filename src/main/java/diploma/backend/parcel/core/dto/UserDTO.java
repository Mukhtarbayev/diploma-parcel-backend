package diploma.backend.parcel.core.dto;

import java.time.LocalDateTime;

public record UserDTO(
        Long id,
        String username,
        String email,
        String password,
        String firstName,
        String lastName,
        String phoneNumber,
        LocalDateTime updatedTime,
        byte[] avatar
){}
