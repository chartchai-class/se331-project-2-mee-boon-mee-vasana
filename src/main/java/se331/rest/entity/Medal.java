package se331.rest.entity;

import jakarta.persistence.*;
import lombok.*;


@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Medal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;

    int goldCount;
    int silverCount;
    int bronzeCount;

    @ManyToOne
    @JoinColumn(name = "country_id")
    Country country;

    @ManyToOne
    @JoinColumn(name = "sport_detail_id")
    SportDetail sportDetail;
}
