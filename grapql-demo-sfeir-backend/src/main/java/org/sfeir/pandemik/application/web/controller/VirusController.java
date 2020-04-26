package org.sfeir.pandemik.application.web.controller;

import lombok.RequiredArgsConstructor;
import org.sfeir.pandemik.domain.adapters.input.VirusAdapter;
import org.sfeir.pandemik.domain.entities.VirusEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.notFound;

@RestController
@RequestMapping("/virus")
@RequiredArgsConstructor
public class VirusController {

    private final VirusAdapter virusAdapter;

    @GetMapping
    public ResponseEntity<List<VirusEntity>> getAll() {
        return new ResponseEntity<>(virusAdapter.fetchAll(), OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<VirusEntity> getByName(@PathVariable("name")String name) {
        return virusAdapter.fetchByName(name).map(entity -> new ResponseEntity<>(entity, OK)).orElseGet(() -> notFound().build());
    }

    @PostMapping
    public ResponseEntity<VirusEntity> save(@RequestBody VirusEntity virusEntity) {
        return new ResponseEntity<>(virusAdapter.save(virusEntity), OK);
    }

}
