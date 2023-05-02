package diploma.backend.parcel.core.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileResponse {
    private String name;
    private String url;
    private String type;
    private Long size;
}
