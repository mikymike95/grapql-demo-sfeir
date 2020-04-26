package org.sfeir.pandemik.application.web.controller;

import lombok.RequiredArgsConstructor;
import org.sfeir.pandemik.domain.adapters.input.CountryAdapter;
import org.sfeir.pandemik.domain.entities.CountryEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.notFound;

@RestController
@RequestMapping("/countries")
@RequiredArgsConstructor
public class CountryController {

    private final CountryAdapter countryAdapter;

    @GetMapping
    public ResponseEntity<List<CountryEntity>> getAll() {
        return new ResponseEntity<>(countryAdapter.fetchAll(), OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<CountryEntity> getByName(@PathVariable("name") String name) {
        return countryAdapter.fetchByName(name).map(entity -> new ResponseEntity<>(entity, OK)).orElseGet(() -> notFound().build());
    }

    @GetMapping(params = {"infection"})
    public ResponseEntity<List<CountryEntity>> getAllInfectedBy(@RequestParam("infection") String infection) {
        return new ResponseEntity<>(countryAdapter.fetchAllByInfection(infection), OK);
    }

    @PostMapping
    public ResponseEntity<CountryEntity> save(@RequestBody CountryEntity countryEntity) {
        return new ResponseEntity<>(countryAdapter.save(countryEntity), OK);
    }
}
