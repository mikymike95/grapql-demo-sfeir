package org.sfeir.pandemik.application.web.controller;

import lombok.RequiredArgsConstructor;
import org.sfeir.pandemik.domain.adapters.input.PatientAdapter;
import org.sfeir.pandemik.domain.entities.PatientEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientAdapter patientAdapter;

    @GetMapping
    public ResponseEntity<List<PatientEntity>> getAll() {
        return new ResponseEntity<>(patientAdapter.fetchAll(), OK);
    }

    @GetMapping("/{firstName}")
    public ResponseEntity<PatientEntity> getByName(@PathVariable("firstName") String firstName) {
        return patientAdapter.fetchByName(firstName).map(e -> new ResponseEntity<>(e, OK)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(params = {"firstName", "lastName"})
    public ResponseEntity<PatientEntity> getByFullNAme(@RequestParam("firstName") String firstName, @RequestParam("firstName") String lastName) {
        return patientAdapter.fetchByFullName(firstName, lastName).map(e -> new ResponseEntity<>(e, OK)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping(params = {"country"})
    public ResponseEntity<List<PatientEntity>> getByCountry(@RequestParam("country") String country) {
        return new ResponseEntity<>(patientAdapter.fetchByTerritory(country), OK);
    }

    @GetMapping(params = {"infection"})
    public ResponseEntity<List<PatientEntity>> getByInfection(@RequestParam("infection") String infection) {
        return new ResponseEntity<>(patientAdapter.fetchByInfection(infection), OK);
    }

    @GetMapping(params = {"country", "infection"})
    public ResponseEntity<List<PatientEntity>> getByCountryAndInfection(@RequestParam("infection") String country, @RequestParam("infection") String infection) {
        return new ResponseEntity<>(patientAdapter.fetchByTerritoryInfectedBy(country, infection), OK);
    }

    @PostMapping
    public ResponseEntity<PatientEntity> save(@RequestBody PatientEntity patientEntity) {
        return new ResponseEntity<>(patientAdapter.save(patientEntity), OK);
    }
}
