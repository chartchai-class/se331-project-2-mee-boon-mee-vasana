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
public class CountryDTO {
     Long id;
     String name;
     String nocCode;
     String flagUrl;
     String basicInfo;

     List<SportDetailDTO> sportDetails;  // เชื่อมโยงกับกีฬาต่าง ๆ
     List<MedalDTO> medals;              // เชื่อมโยงกับเหรียญที่ประเทศได้รับ
}
