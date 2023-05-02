package diploma.backend.parcel.web.controller;

import diploma.backend.parcel.core.dto.request.UpdateUserInfoRequest;
import diploma.backend.parcel.core.dto.response.UserInfoResponse;
import diploma.backend.parcel.core.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {
    private final UserService userService;

    @GetMapping("/get/{id}")
    public ResponseEntity<UserInfoResponse> getUserById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateUserById(
            @RequestBody UpdateUserInfoRequest request
    ){
        return ResponseEntity.ok(userService.updateUserById(request));
    }

//    public ResponseEntity<?> upload(){
//
//    }
}
