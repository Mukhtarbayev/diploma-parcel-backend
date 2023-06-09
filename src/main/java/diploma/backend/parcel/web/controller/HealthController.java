package diploma.backend.parcel.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class HealthController {
    @GetMapping("")
    public ResponseEntity<String> health(){
        return ResponseEntity.ok("Application is working");
    }
}
