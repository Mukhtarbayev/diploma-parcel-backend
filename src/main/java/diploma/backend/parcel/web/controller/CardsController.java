package diploma.backend.parcel.web.controller;

import diploma.backend.parcel.core.dto.CardDTO;
import diploma.backend.parcel.core.dto.request.CreateCardRequest;
import diploma.backend.parcel.core.dto.request.FilterRequest;
import diploma.backend.parcel.core.dto.request.UpdateCardRequest;
import diploma.backend.parcel.core.dto.request.UserCardsRequest;
import diploma.backend.parcel.core.service.CardService;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardsController {
    private final CardService cardService;

    @GetMapping("/getCardsByUserId/{id}")
    public ResponseEntity<List<CardDTO>> getCardsByUser(@PathVariable Long id){
        return ResponseEntity.ok(cardService.getCardsByUserId(id));
    }

    @GetMapping("/getForDeparting")
    public ResponseEntity<List<CardDTO>> getForDeparting(){
        return ResponseEntity.ok(cardService.getForDeparting());
    }

    @GetMapping("/getForTransmitting")
    public ResponseEntity<List<CardDTO>> getForTransmitting(){
        return ResponseEntity.ok(cardService.getForTransmitting());
    }

    @GetMapping("/getCities")
    public ResponseEntity<List<String>> getCities(){
        return ResponseEntity.ok(List.of("Almaty", "Aktobe", "Astana", "Atyrau", "Aktau", "Shymkent", "Karagandy", "Taraz", "Oskemen", "Pavlodar", "Semey",
                "Kyzylorda", "Kostanay", "Oral", "Petropavl", "Turkistan", "Kokshetau", "Temirtau", "Taldykorgan", "Temirtau", "Rudnyi"));
    }

    @PostMapping("/filter")
    public ResponseEntity<List<CardDTO>> getWithFilter(@RequestBody FilterRequest filterRequest){
        return ResponseEntity.ok(cardService.getWithFilter(filterRequest));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createCard(
            @RequestBody CreateCardRequest request
    ){
        return ResponseEntity.ok(cardService.createCard(request));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CardDTO> getCardById(
            @PathVariable Long id
    ){
        return ResponseEntity.ok(cardService.getCardById(id));
    }

    @PostMapping("/update")
    public ResponseEntity<?> updateCard(
            @RequestBody UpdateCardRequest request
    ){
        return ResponseEntity.ok(cardService.updateCard(request));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteCard(
            @PathVariable Long id){
        return ResponseEntity.ok(cardService.deleteCard(id));
    }
}
