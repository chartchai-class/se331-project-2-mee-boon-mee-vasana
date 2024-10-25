package se331.rest.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Country {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @EqualsAndHashCode.Exclude
     Long id;

     String name;
     String nocCode;
     String flagUrl;
     String basicInfo;

     @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
     List<SportDetail> details;

     @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
     List<Medal> medals;
}
