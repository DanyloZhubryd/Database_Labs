package ua.lviv.iot.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ua.lviv.iot.DTO.DistrictDTO;
import ua.lviv.iot.domain.District;
import ua.lviv.iot.mapper.implementation.DistrictMapper;
import ua.lviv.iot.service.implementation.DistrictService;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/district")
@RestController
@AllArgsConstructor
public class DistrictController{
    private final DistrictService districtService;
    private final DistrictMapper districtMapper;

    @GetMapping
    public ResponseEntity<List<DistrictDTO>> getAll() {
        List<DistrictDTO> dtoList = districtService.getAll().stream().map(districtMapper::map).collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<DistrictDTO> get(@PathVariable Integer id) {
        return new ResponseEntity<>(districtMapper.map(districtService.get(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<DistrictDTO> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(districtMapper.map(districtService.delete(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DistrictDTO> create(@RequestBody District district) {
        return new ResponseEntity<>(districtMapper.map(districtService.create(district)), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<DistrictDTO> update(@PathVariable Integer id, @RequestBody District district) {
        return new ResponseEntity<>(districtMapper.map(districtService.update(id, district)), HttpStatus.OK);
    }
}
