package se331.rest.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedalDTO {
     Long id;
     int goldCount;
     int silverCount;
     int bronzeCount;

}
