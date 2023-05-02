package diploma.backend.parcel.core.repository;

import diploma.backend.parcel.core.model.FileModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileRepository extends JpaRepository<FileModel, String> {
    @Transactional
    Optional<FileModel> findByUserId(Long userId);
}
