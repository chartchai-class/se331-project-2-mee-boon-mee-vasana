package se331.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

}
