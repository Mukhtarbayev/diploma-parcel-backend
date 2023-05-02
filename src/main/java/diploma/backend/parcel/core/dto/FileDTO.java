package diploma.backend.parcel.core.dto;

public record FileDTO(
        String id,
        Long userId,
        String type,
        byte[] data
) {}
