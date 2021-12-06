package ua.lviv.iot.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DTO.ChildDTO;
import ua.lviv.iot.domain.Child;
import ua.lviv.iot.mapper.implementation.ChildMapper;
import ua.lviv.iot.service.implementation.ChildService;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/child")
@RestController
@AllArgsConstructor
public class ChildController {
    private final ChildService childService;
    private final ChildMapper childMapper;

    @GetMapping
    public ResponseEntity<List<ChildDTO>> getAll() {
        List<ChildDTO> dtoList = childService.getAll().stream().map(childMapper::map).collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ChildDTO> get(@PathVariable Integer id) {
        return new ResponseEntity<>(childMapper.map(childService.get(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ChildDTO> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(childMapper.map(childService.delete(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ChildDTO> create(@RequestBody Child child) {
        return new ResponseEntity<>(childMapper.map(childService.create(child)), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ChildDTO> update(@PathVariable Integer id, @RequestBody Child child) {
        return new ResponseEntity<>(childMapper.map(childService.update(id, child)), HttpStatus.OK);
    }
}
