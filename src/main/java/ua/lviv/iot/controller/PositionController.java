package ua.lviv.iot.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DTO.PositionDTO;
import ua.lviv.iot.domain.Position;
import ua.lviv.iot.mapper.implementation.PositionMapper;
import ua.lviv.iot.service.implementation.PositionService;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/position")
@RestController
@AllArgsConstructor
public class PositionController {
    private final PositionService positionService;
    private final PositionMapper positionMapper;

    @GetMapping
    public ResponseEntity<List<PositionDTO>> getAll() {
        List<PositionDTO> dtoList = positionService.getAll().stream().map(positionMapper::map).collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PositionDTO> get(@PathVariable Integer id) {
        return new ResponseEntity<>(positionMapper.map(positionService.get(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<PositionDTO> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(positionMapper.map(positionService.delete(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PositionDTO> create(@RequestBody Position position) {
        return new ResponseEntity<>(positionMapper.map(positionService.create(position)), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<PositionDTO> update(@PathVariable Integer id, @RequestBody Position position) {
        return new ResponseEntity<>(positionMapper.map(positionService.update(id, position)), HttpStatus.OK);
    }
}
