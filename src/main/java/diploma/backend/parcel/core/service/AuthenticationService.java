package diploma.backend.parcel.core.service;

import diploma.backend.parcel.core.exception.UserRegisteredException;
import diploma.backend.parcel.core.model.UserModel;
import diploma.backend.parcel.core.repository.UserRepository;
import diploma.backend.parcel.web.configuration.JwtService;
import diploma.backend.parcel.core.dto.request.LoginRequest;
import diploma.backend.parcel.core.dto.request.RegisterRequest;
import diploma.backend.parcel.core.dto.response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    public AuthenticationResponse register(RegisterRequest request) throws UserRegisteredException {
        var contains = userRepository.findByUsernameOrEmail(request.getUsername(), request.getEmail()).isPresent();
        if(contains){
            throw new UserRegisteredException();
        }
        var user = UserModel.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .phoneNumber(request.getPhoneNumber())
                .createdTime(LocalDateTime.now())
                .updatedTime(LocalDateTime.now())
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).id(user.getId()).build();
    }

    public AuthenticationResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = userRepository.findByUsernameOrEmail(request.getUsername(), request.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse
                .builder()
                .token(jwtToken)
                .id(user.getId())
                .build();
    }
}
