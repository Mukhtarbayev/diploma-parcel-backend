package diploma.backend.parcel.core.repository;

import diploma.backend.parcel.core.model.UserModel;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    Optional<UserModel> findByUsernameOrEmail(String username, String email);
    @NotNull Optional<UserModel> findById(@NotNull Long id);

}