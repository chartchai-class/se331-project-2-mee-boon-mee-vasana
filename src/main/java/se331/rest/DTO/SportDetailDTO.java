package se331.rest.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SportDetailDTO {
     Long id;
     String sportName;
     int rank;
     String medalsUrl;
     Long countryId;       // เชื่อมโยงกับประเทศ
     String countryName;   // ชื่อประเทศที่เกี่ยวข้อง

}
