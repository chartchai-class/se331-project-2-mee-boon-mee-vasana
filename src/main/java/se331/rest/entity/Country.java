package se331.rest.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

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
     String description;
     int gold;
     int silver;
     int bronze;
     int total;
}
