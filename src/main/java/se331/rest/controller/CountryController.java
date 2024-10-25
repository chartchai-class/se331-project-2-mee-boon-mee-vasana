package se331.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import se331.rest.entity.Country;
import se331.rest.service.CountryService;
import se331.rest.utill.EntityMapper;
import org.springframework.web.server.ResponseStatusException;



@RequiredArgsConstructor
@Controller
public class CountryController {
    final CountryService countryService;
    // GET - Fetch all countries with pagination and optional title filter
    @GetMapping("/countries")
    public ResponseEntity<?> getCountryLists(
            @RequestParam(value = "_limit", required = false) Integer perPage,
            @RequestParam(value = "_page", required = false) Integer page,
            @RequestParam(value = "name", required = false) String name) {

        // Set default values if not provided
        perPage = (perPage == null) ? 3 : perPage;
        page = (page == null) ? 1 : page;

        // Fetch countries with or without filtering by name
        Page<Country> pageOutput;
        if (name == null) {
            pageOutput = countryService.getAllCountries(perPage, page);
        } else {
            pageOutput = countryService.getAllCountries(name, PageRequest.of(page - 1, perPage));
        }

        // Set custom header for total count of elements
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("X-Total-Count", String.valueOf(pageOutput.getTotalElements()));

        // Map entities to DTO and return response with header
        return new ResponseEntity<>(EntityMapper.INSTANCE.getCountryDTO(pageOutput.getContent()), responseHeader, HttpStatus.OK);
    }

    // GET - Fetch a specific country by ID
    @GetMapping("/countries/{id}")
    public ResponseEntity<?> getCountry(@PathVariable("id") Long id) {
        Country country = countryService.getCountryById(id);
        if (country != null) {
            return ResponseEntity.ok(EntityMapper.INSTANCE.getCountryDTO(country));
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The given id is not found");
        }
    }

    // POST - Add a new country
    @PostMapping("/countries")
    public ResponseEntity<?> addCountry(@RequestBody Country country) {
        Country savedCountry = countryService.saveCountry(country);
        return ResponseEntity.ok(EntityMapper.INSTANCE.getCountryDTO(savedCountry));
    }

}
