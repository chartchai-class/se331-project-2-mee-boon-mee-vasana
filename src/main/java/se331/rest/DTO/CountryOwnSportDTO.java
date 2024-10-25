package se331.rest.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import se331.rest.entity.Medal;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CountryOwnSportDTO {
    Long id;
    String sportName;
    int rankPosition;
    String medalsUrl;
//    List<MedalDTO> medals;
}
