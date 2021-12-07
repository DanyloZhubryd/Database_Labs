package ua.lviv.iot.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DTO.StreetDTO;
import ua.lviv.iot.domain.Street;
import ua.lviv.iot.mapper.implementation.StreetMapper;
import ua.lviv.iot.service.implementation.StreetService;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/street")
@RestController
@AllArgsConstructor
public class StreetController {
    private final StreetService streetService;
    private final StreetMapper streetMapper;

    @GetMapping
    public ResponseEntity<List<StreetDTO>> getAll() {
        List<StreetDTO> dtoList = streetService.getAll().stream().map(streetMapper::map).collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<StreetDTO> get(@PathVariable Integer id) {
        return new ResponseEntity<>(streetMapper.map(streetService.get(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<StreetDTO> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(streetMapper.map(streetService.delete(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StreetDTO> create(@RequestBody Street street) {
        return new ResponseEntity<>(streetMapper.map(streetService.create(street)), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<StreetDTO> update(@PathVariable Integer id, @RequestBody Street street) {
        return new ResponseEntity<>(streetMapper.map(streetService.update(id, street)), HttpStatus.OK);
    }
}
