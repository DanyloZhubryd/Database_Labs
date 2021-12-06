package ua.lviv.iot.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DTO.KindergardenDTO;
import ua.lviv.iot.domain.Kindergarden;
import ua.lviv.iot.mapper.implementation.KindergardenMapper;
import ua.lviv.iot.service.implementation.KindergardenService;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/kindergarden")
@RestController
@AllArgsConstructor
public class KindergardenController {
    private final KindergardenService kindergardenService;
    private final KindergardenMapper kindergardenMapper;

    @GetMapping
    public ResponseEntity<List<KindergardenDTO>> getAll() {
        List<KindergardenDTO> dtoList = kindergardenService.getAll().stream().map(kindergardenMapper::map).collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<KindergardenDTO> get(@PathVariable Integer id) {
        return new ResponseEntity<>(kindergardenMapper.map(kindergardenService.get(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<KindergardenDTO> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(kindergardenMapper.map(kindergardenService.delete(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<KindergardenDTO> create(@RequestBody Kindergarden kindergarden) {
        return new ResponseEntity<>(kindergardenMapper.map(kindergardenService.create(kindergarden)), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<KindergardenDTO> update(@PathVariable Integer id, @RequestBody Kindergarden kindergarden) {
        return new ResponseEntity<>(kindergardenMapper.map(kindergardenService.update(id, kindergarden)), HttpStatus.OK);
    }
}
