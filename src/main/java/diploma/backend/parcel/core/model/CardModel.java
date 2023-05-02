package diploma.backend.parcel.core.model;

import diploma.backend.parcel.core.enums.CardType;
import diploma.backend.parcel.core.enums.TransportType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cards")
public class CardModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch=FetchType.LAZY, cascade={ CascadeType.PERSIST, CascadeType.MERGE })
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel user;
    private Integer weight;
    @Enumerated(EnumType.STRING)
    private TransportType transportType;
    @Enumerated(EnumType.STRING)
    private CardType type;
    private String cityFrom;
    private String cityTo;
    private LocalDateTime arrivingTime;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
