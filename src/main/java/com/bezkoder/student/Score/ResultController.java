package com.bezkoder.student.Score;

import org.springframework.hateoas.*;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/result")
public class ResultController {

    ResultService resultService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResultDTO addScore(@RequestBody ScoreRecord scoreRecord) {

        return resultService.addScore(scoreRecord);
    }

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findAll(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size) {
        CollectionModel<ResultDTO> resultDTOS = resultService.findAll(page, size);
        if (resultDTOS != null) {
            return ResponseEntity.ok(resultDTOS);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findScoreById(@PathVariable Long id) {
        ResultDTO resultDTO = resultService.findScoreById(id);
        if (resultDTO != null) return ResponseEntity.ok(resultDTO);
        return ResponseEntity.noContent().build();
    }
}
