package se331.rest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
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

    int rankPosition;

    String medalsUrl;

    @ManyToOne
    Country country;


    @OneToMany(mappedBy = "sportDetail", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    List<Medal> medals = new ArrayList<>();
}

