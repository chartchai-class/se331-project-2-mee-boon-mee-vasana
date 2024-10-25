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
    HttpHeaders headers = new HttpHeaders();
    @GetMapping("countries")
    public ResponseEntity<List<Country>> getAllCountries(@RequestParam(value = "_limit", required = false) Integer perPage,
                                                         @RequestParam(value = "_page", required = false) Integer page) {

        perPage = perPage == null ? 3 : perPage;
        page = page == null ? 1 : page;
        Page<Country> output = countryService.getCountries(perPage, page);

        // ดึงเฉพาะข้อมูล content ออกมา
        List<Country> content = output.getContent();

        // ส่งเฉพาะ content กลับไปใน response
        return new ResponseEntity<>(content, HttpStatus.OK);
    }

}
