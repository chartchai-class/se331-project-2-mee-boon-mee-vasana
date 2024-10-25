package se331.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import se331.rest.DTO.MedalDTO;
import se331.rest.entity.Medal;
import se331.rest.service.MedalService;
import se331.rest.utill.EntityMapper;

@RequiredArgsConstructor
@Controller

public class MedalController {
    final MedalService medalService;

    // Get all medals with pagination
    @GetMapping("/medals")
    public ResponseEntity<?> getMedals(){
        return ResponseEntity.ok(EntityMapper.INSTANCE.getMedalDTO(medalService.getAllMedals()));
    }


}
