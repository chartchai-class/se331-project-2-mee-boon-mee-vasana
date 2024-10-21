package se331.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import se331.rest.entity.Country;
import se331.rest.service.CountryService;

import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Controller
public class CountryController {
    final CountryService countryService;
    @GetMapping("countries")
    public ResponseEntity<?> getAllCountries(@RequestParam(value = "_limit", required = false) Integer perPage,
                                             @RequestParam(value = "_page", required = false) Integer page) {


        List<Country> output = null;
        Page<Country> eventSize = countryService.getCountries(perPage,page);
        HttpHeaders responseHeader = new HttpHeaders();
        responseHeader.set("x-total-count", String.valueOf(eventSize));
        try {
            return new ResponseEntity<>(output,responseHeader, HttpStatus.OK);
        } catch (IndexOutOfBoundsException ex) {
            return ResponseEntity.ok(output);
        }
//        return ResponseEntity.ok(output);


    }

}
