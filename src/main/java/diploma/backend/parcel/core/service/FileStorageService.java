package diploma.backend.parcel.core.service;

import diploma.backend.parcel.core.dto.FileDTO;
import diploma.backend.parcel.core.dto.FileDTOMapper;
import diploma.backend.parcel.core.model.FileModel;
import diploma.backend.parcel.core.repository.FileRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class FileStorageService {

    private final FileRepository fileRepository;
    private final FileDTOMapper mapper;

    public String store(MultipartFile file, Long userId) throws IOException {
        deleteIfExist(userId);
        Long fileName = userId;
        FileModel fileModel = new FileModel(fileName, file.getContentType(), file.getBytes());

        fileRepository.save(fileModel);
        return "Successfully created";
    }

    public FileDTO getFile(Long userId) {
        return mapper.apply(fileRepository.findByUserId(userId).get());
    }

    private void deleteIfExist(Long userId){
        fileRepository.deleteById(fileRepository.findByUserId(userId).get().getId());
    }
}
