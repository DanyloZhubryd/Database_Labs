package ua.lviv.iot.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.iot.DTO.WorkerDTO;
import ua.lviv.iot.domain.Worker;
import ua.lviv.iot.mapper.implementation.WorkerMapper;
import ua.lviv.iot.service.implementation.WorkerService;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping(value = "/worker")
@RestController
@AllArgsConstructor
public class WorkerController {
    private final WorkerService workerService;
    private final WorkerMapper workerMapper;

    @GetMapping
    public ResponseEntity<List<WorkerDTO>> getAll() {
        List<WorkerDTO> dtoList = workerService.getAll().stream().map(workerMapper::map).collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<WorkerDTO> get(@PathVariable Integer id) {
        return new ResponseEntity<>(workerMapper.map(workerService.get(id)), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<WorkerDTO> delete(@PathVariable Integer id) {
        return new ResponseEntity<>(workerMapper.map(workerService.delete(id)), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<WorkerDTO> create(@RequestBody Worker worker) {
        return new ResponseEntity<>(workerMapper.map(workerService.create(worker)), HttpStatus.OK);
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<WorkerDTO> update(@PathVariable Integer id, @RequestBody Worker worker) {
        return new ResponseEntity<>(workerMapper.map(workerService.update(id, worker)), HttpStatus.OK);
    }

}
