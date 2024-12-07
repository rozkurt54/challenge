package org.enoca.challenge.unit.controllers;

import jakarta.validation.Valid;
import org.enoca.challenge.core.tools.StandardizedResponseUtil;
import org.enoca.challenge.unit.dtos.requests.UnitRequestDto;
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

        var message = String.format("%d results are retrieved.", result.size());

        var response = StandardizedResponseUtil.createSuccessResponse(HttpStatus.OK, message, result);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOneUnit(@PathVariable String id) {

        var result = iUnitService.getOne(id);

        var message = String.format("%s id's unit has retrieved.", result.getId());

        var response = StandardizedResponseUtil.createSuccessResponse(HttpStatus.OK, message, result);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PostMapping()
    public ResponseEntity<?> createUnit(@Valid @RequestBody UnitRequestDto unitRequestDto) {

        var result = iUnitService.create(unitRequestDto);

        var message = String.format("%s named unit has been created.", result.getName());

        var response = StandardizedResponseUtil.createSuccessResponse(HttpStatus.OK, message, result);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUnit(@PathVariable String id, @Valid @RequestBody UnitRequestDto unitRequestDto) {

        var result =  iUnitService.update(id, unitRequestDto);

        var message = String.format("%s id's unit has updated.", result.getId());

        var response = StandardizedResponseUtil.createSuccessResponse(HttpStatus.OK, message, result);

        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUnit(@PathVariable String id) {

        iUnitService.delete(id);

        var message = String.format("%s id's unit has been deleted", id);

        var response = StandardizedResponseUtil.createSuccessResponse(HttpStatus.OK, message);

        return ResponseEntity.ok(response);

    }


}
