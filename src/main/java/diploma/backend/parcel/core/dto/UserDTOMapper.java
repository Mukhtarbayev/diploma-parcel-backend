package diploma.backend.parcel.core.dto;

import diploma.backend.parcel.core.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class UserDTOMapper implements Function<UserModel, UserDTO> {
    @Override
    public UserDTO apply(UserModel userModel) {
        return new UserDTO(
                userModel.getId(),
                userModel.getUsername(),
                userModel.getEmail(),
                userModel.getPassword(),
                userModel.getFirstName(),
                userModel.getLastName(),
                userModel.getPhoneNumber(),
                userModel.getUpdatedTime(),
                userModel.getAvatar()
        );
    }
}
