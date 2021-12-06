package ua.lviv.iot.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DTO.ChildGroupDTO;
import ua.lviv.iot.domain.ChildGroup;
import ua.lviv.iot.mapper.implementation.ChildGroupMapper;
import ua.lviv.iot.service.implementation.ChildGroupService;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/child-group")
@RestController
@AllArgsConstructor
public class ChildGroupController {
    private final ChildGroupService service;
    private final ChildGroupMapper mapper;

    @GetMapping
    public ResponseEntity<List<ChildGroupDTO>> getAll() {
        List<ChildGroupDTO> dtoList = service.getAll().stream().map(mapper::map).collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ChildGroupDTO> get(@PathVariable Integer id) {
        return new ResponseEntity<>(mapper.map(service.get(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ChildGroupDTO> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(mapper.map(service.delete(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ChildGroupDTO> create(@RequestBody ChildGroup childGroup) {
        return new ResponseEntity<>(mapper.map(service.create(childGroup)), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ChildGroupDTO> update(@PathVariable Integer id, @RequestBody ChildGroup childGroup) {
        return new ResponseEntity<>(mapper.map(service.update(id, childGroup)), HttpStatus.OK);
    }
}
