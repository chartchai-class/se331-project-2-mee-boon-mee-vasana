package se331.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import se331.rest.entity.Country;
import se331.rest.entity.SportDetail;
import se331.rest.service.SportDetailService;
import se331.rest.utill.EntityMapper;

@RequiredArgsConstructor
@Controller
public class SportDetailController {
    final SportDetailService sportDetailService;
    @GetMapping("/sports")
    public ResponseEntity<?> getMedals(){
        return ResponseEntity.ok(EntityMapper.INSTANCE.getSportDetailDTO(sportDetailService.getAllSports()));
    }
    @GetMapping("/sports/{id}")
    public ResponseEntity<?> getCountry(@PathVariable("id") Long id) {
        SportDetail sportDetail = sportDetailService.getSportById(id);
        if (sportDetail != null) {
            return ResponseEntity.ok(EntityMapper.INSTANCE.getSportDetailDTO(sportDetail));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

}
