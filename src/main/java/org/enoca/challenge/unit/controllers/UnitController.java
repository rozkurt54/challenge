package org.enoca.challenge.unit.controllers;

import org.enoca.challenge.unit.Dtos.requests.UnitRequestDto;
import org.enoca.challenge.unit.services.IUnitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/units")
public class UnitController {

    private final IUnitService iUnitService;

    public UnitController(IUnitService iUnitService) {
        this.iUnitService = iUnitService;
    }

    @GetMapping()
    public ResponseEntity<?> getAllUnits() {

        var result = iUnitService.getAll();

        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneUnit(@PathVariable String id) {

        var result = iUnitService.getOne(id);

        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @PostMapping()
    public ResponseEntity<?> createUnit(@RequestBody UnitRequestDto unitRequestDto) {

        var result = iUnitService.create(unitRequestDto);

        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUnit(@PathVariable String id, @RequestBody UnitRequestDto unitRequestDto) {

        var result =  iUnitService.update(id, unitRequestDto);

        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUnit(@PathVariable String id) {

        iUnitService.delete(id);

        return ResponseEntity.ok().build();

    }


}
