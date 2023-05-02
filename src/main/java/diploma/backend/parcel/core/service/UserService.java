package diploma.backend.parcel.core.service;

import diploma.backend.parcel.core.dto.UserDTO;
import diploma.backend.parcel.core.dto.UserDTOMapper;
import diploma.backend.parcel.core.dto.request.UpdateUserInfoRequest;
import diploma.backend.parcel.core.dto.response.UserInfoResponse;
import diploma.backend.parcel.core.model.UserModel;
import diploma.backend.parcel.core.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserDTOMapper userDTOMapper;

    public UserInfoResponse getUserById(Long id){
        var userDto =  userDTOMapper.apply(userRepository.findById(id).orElseThrow());
        return new UserInfoResponse(
                userDto.id(),
                userDto.username(),
                userDto.email(),
                userDto.firstName(),
                userDto.lastName(),
                userDto.phoneNumber(),
                userDto.updatedTime()
        );
    }

    @Transactional
    public String updateUserById(UpdateUserInfoRequest request) {
        UserModel userModel = userRepository.findById(request.id()).orElseThrow();
        if(request.firstName() != null){
            userModel.setFirstName(request.firstName());
        }
        if(request.lastName() != null){
            userModel.setLastName(request.lastName());
        }
        if(request.phoneNumber() != null){
            userModel.setPhoneNumber(request.phoneNumber());
        }
        userModel.setUpdatedTime(LocalDateTime.now());

        return "Successfully updated";
    }
}

