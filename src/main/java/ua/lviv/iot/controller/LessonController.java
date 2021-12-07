package ua.lviv.iot.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DTO.LessonDTO;
import ua.lviv.iot.domain.Lesson;
import ua.lviv.iot.mapper.implementation.LessonMapper;
import ua.lviv.iot.service.implementation.LessonService;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/lesson")
@RestController
@AllArgsConstructor
public class LessonController  {
    private final LessonService lessonService;
    private final LessonMapper lessonMapper;

    @GetMapping
    public ResponseEntity<List<LessonDTO>> getAll() {
        List<LessonDTO> dtoList = lessonService.getAll().stream().map(lessonMapper::map).collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<LessonDTO> get(@PathVariable Integer id) {
        return new ResponseEntity<>(lessonMapper.map(lessonService.get(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<LessonDTO> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(lessonMapper.map(lessonService.delete(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<LessonDTO> create(@RequestBody Lesson lesson) {
        return new ResponseEntity<>(lessonMapper.map(lessonService.create(lesson)), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<LessonDTO> update(@PathVariable Integer id, @RequestBody Lesson lesson) {
        return new ResponseEntity<>(lessonMapper.map(lessonService.update(id, lesson)), HttpStatus.OK);
    }
}
