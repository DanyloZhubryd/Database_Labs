package ua.lviv.iot.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DTO.AddressDTO;
import ua.lviv.iot.domain.Address;
import ua.lviv.iot.mapper.implementation.AddressMapper;
import ua.lviv.iot.service.implementation.AddressService;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/address")
@RestController
@AllArgsConstructor
public class AddressController {
    private final AddressService addressService;
    private final AddressMapper addressMapper;

    @GetMapping
    public ResponseEntity<List<AddressDTO>> getAll() {
        List<AddressDTO> dtoList = addressService.getAll().stream().map(addressMapper::map).collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AddressDTO> get(@PathVariable Integer id) {
        return new ResponseEntity<>(addressMapper.map(addressService.get(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<AddressDTO> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(addressMapper.map(addressService.delete(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AddressDTO> create(@RequestBody Address entity) {
        return new ResponseEntity<>(addressMapper.map(addressService.create(entity)), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<AddressDTO> update(@PathVariable Integer id, @RequestBody Address address) {
        return new ResponseEntity<>(addressMapper.map(addressService.update(id, address)), HttpStatus.OK);
    }
}
