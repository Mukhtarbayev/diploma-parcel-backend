package diploma.backend.parcel.core.service;

import diploma.backend.parcel.core.dto.CardDTO;
import diploma.backend.parcel.core.dto.CardDTOMapper;
import diploma.backend.parcel.core.dto.request.CreateCardRequest;
import diploma.backend.parcel.core.dto.request.FilterRequest;
import diploma.backend.parcel.core.dto.request.UpdateCardRequest;
import diploma.backend.parcel.core.enums.CardType;
import diploma.backend.parcel.core.model.CardModel;
import diploma.backend.parcel.core.model.UserModel;
import diploma.backend.parcel.core.repository.CardRepository;
import diploma.backend.parcel.core.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;
    private final UserRepository userRepository;
    private final CardDTOMapper cardDTOMapper;

    public List<CardDTO> getCardsByUserId(Long id){
        return cardRepository.findAllByUserId(id)
                .stream().map(cardDTOMapper).collect(Collectors.toList());
    }

    public List<CardDTO> getForDeparting(){
        return cardRepository.findAllByCardType(CardType.DEPARTING)
                .stream().map(cardDTOMapper).collect(Collectors.toList());
    }

    public List<CardDTO> getForTransmitting(){
        return cardRepository.findAllByCardType(CardType.TRANSMITTING)
                .stream().map(cardDTOMapper).collect(Collectors.toList());
    }

    public String createCard(CreateCardRequest request){
        UserModel userModel = userRepository.findById(request.userId()).orElseThrow();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        LocalDateTime arrivingTime = LocalDateTime.parse(request.arrivingTime(), formatter);
        cardRepository.save(
                new CardModel(
                        0L,
                        userModel,
                        request.weight(),
                        request.transportType(),
                        request.cardType(),
                        request.cityFrom(),
                        request.cityTo(),
                        arrivingTime,
                        LocalDateTime.now(),
                        LocalDateTime.now()
                )
        );

        return "Successfully created";
    }

    @Transactional
    public String updateCard(UpdateCardRequest request) {
        CardModel cardModel = cardRepository.findById(request.id()).orElseThrow();
        if(request.weight() != null){
            cardModel.setWeight(request.weight());
        }
        if(request.transportType() != null){
            cardModel.setTransportType(request.transportType());
        }
        if(request.cardType() != null){
            cardModel.setType(request.cardType());
        }
        if(request.cityFrom() != null){
            cardModel.setCityFrom(request.cityFrom());
        }
        if(request.cityTo() != null){
            cardModel.setCityTo(request.cityTo());
        }
        if(request.arrivingTime() != null){
            cardModel.setArrivingTime(request.arrivingTime());
        }
        cardModel.setUpdatedTime(LocalDateTime.now());

        return "Successfully updated";
    }

    public String deleteCard(Long id) {
        cardRepository.deleteById(id);
        return "Successfully deleted";
    }

    public CardDTO getCardById(Long id) {
        return cardDTOMapper.apply(cardRepository.findById(id).orElseThrow());
    }

    public List<CardDTO> getWithFilter(FilterRequest filterRequest) {
        System.out.println(filterRequest.to());
        return cardRepository.findByFilter(filterRequest.from(), filterRequest.to(), filterRequest.when())
                .stream().map(cardDTOMapper).collect(Collectors.toList());
    }
}
