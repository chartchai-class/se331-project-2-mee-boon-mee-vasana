package se331.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import se331.rest.DTO.CommentDTO;
import se331.rest.entity.Comment;
import se331.rest.entity.Country;
import se331.rest.service.CommentService;
import se331.rest.service.CountryService;
import se331.rest.utill.EntityMapper;

import java.util.List;

@RequestMapping("/comments")
@RequiredArgsConstructor
@Controller
public class CommentController {
    final CommentService commentService;
    final CountryService countryService;
    @PostMapping("/add")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<CommentDTO> addComment(@RequestBody Comment comment) {
        Comment savedComment = commentService.addComment(comment);
        CommentDTO commentDTO = EntityMapper.INSTANCE.getCommentDTO(savedComment);
        return ResponseEntity.ok(commentDTO);
    }

    @GetMapping("/country/{countryId}")
    public ResponseEntity<List<CommentDTO>> getCommentsByCountry(@PathVariable Long countryId) {
        Country country = countryService.getCountryById(countryId);
        List<Comment> comments = commentService.getCommentsByCountry(country);
        List<CommentDTO> commentDTOs = EntityMapper.INSTANCE.getCommentDTO(comments);
        return ResponseEntity.ok(commentDTOs);
    }

}
