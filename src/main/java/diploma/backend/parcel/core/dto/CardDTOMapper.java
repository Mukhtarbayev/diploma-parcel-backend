package diploma.backend.parcel.core.dto;

import diploma.backend.parcel.core.model.CardModel;
import diploma.backend.parcel.core.model.UserModel;
import diploma.backend.parcel.core.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CardDTOMapper implements Function<CardModel, CardDTO> {
    @Override
    public CardDTO apply(CardModel cardModel) {

        UserModel user = cardModel.getUser();

        return new CardDTO(
                cardModel.getId(),
                cardModel.getUser().getId(),
                cardModel.getWeight(),
                cardModel.getTransportType(),
                cardModel.getType(),
                cardModel.getCityFrom(),
                cardModel.getCityTo(),
                cardModel.getArrivingTime(),
                cardModel.getUpdatedTime(),
                user.getFirstName()+" "+user.getLastName(),
                user.getPhoneNumber()
        );
    }
}
