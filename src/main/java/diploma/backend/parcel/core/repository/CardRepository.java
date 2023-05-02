package diploma.backend.parcel.core.repository;

import diploma.backend.parcel.core.enums.CardType;
import diploma.backend.parcel.core.model.CardModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<CardModel, Long> {
    @Query(" from cards where user.id = :userId")
    List<CardModel> findAllByUserId(Long userId);

    @Query(" from cards where type = :type")
    List<CardModel> findAllByCardType(CardType type);

    @Query("from cards where " +
            " (:cityFrom is null or cityFrom = :cityFrom) and " +
            " (:cityTo is null or cityTo = :cityTo) and " +
            " (cast(:arrivingTime as date) is null or arrivingTime = :arrivingTime)")
    List<CardModel> findByFilter(String cityFrom, String cityTo, LocalDateTime arrivingTime);
}
