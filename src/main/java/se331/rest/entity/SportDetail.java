package se331.rest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class SportDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    Long id;

    String sportName;

    @Column(name = "`rank_position`") // Renamed to avoid conflicts with SQL reserved words
    int rankPosition;

    String medalsUrl;

    @ManyToOne
    @JoinColumn(name = "country_id")
    Country country;

    @OneToMany(mappedBy = "sportDetail", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Medal> medals;
}

