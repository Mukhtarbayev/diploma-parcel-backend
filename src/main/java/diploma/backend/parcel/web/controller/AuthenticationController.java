package diploma.backend.parcel.web.controller;

import diploma.backend.parcel.core.service.AuthenticationService;
import diploma.backend.parcel.core.exception.UserRegisteredException;
import diploma.backend.parcel.core.dto.request.LoginRequest;
import diploma.backend.parcel.core.dto.request.RegisterRequest;
import diploma.backend.parcel.core.dto.response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<?> register(
            @RequestBody RegisterRequest request
    ) {
        try {
            return ResponseEntity.ok(service.register(request));
        } catch (UserRegisteredException e) {
            return ResponseEntity.ok(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody LoginRequest request
    ) {
        return ResponseEntity.ok(service.login(request));
    }
}
