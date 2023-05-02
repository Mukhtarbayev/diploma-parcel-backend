package diploma.backend.parcel.web.controller;

import diploma.backend.parcel.core.dto.FileDTO;
import diploma.backend.parcel.core.service.FileStorageService;
import diploma.backend.parcel.core.util.ImageUtility;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class FileController {
    private final FileStorageService storageService;

    @PostMapping("/upload/{userId}")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file, @PathVariable("userId") Long userId) throws IOException {
        return ResponseEntity.ok(storageService.store(file, userId));
    }

    @GetMapping(path = {"/get/{userId}"})
    public ResponseEntity<byte[]> getImage(@PathVariable("userId") Long userId) {
        FileDTO file = storageService.getFile(userId);
        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(file.type()))
                .body(ImageUtility.decompressImage(file.data()));
    }
}
