package diploma.backend.parcel.core.dto;

import diploma.backend.parcel.core.model.FileModel;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class FileDTOMapper implements Function<FileModel, FileDTO> {
    @Override
    public FileDTO apply(FileModel fileModel) {

        return new FileDTO(
                fileModel.getId(),
                fileModel.getUserId(),
                fileModel.getType(),
                fileModel.getData()
        );
    }
}
