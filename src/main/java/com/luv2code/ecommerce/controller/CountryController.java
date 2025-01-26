package com.luv2code.ecommerce.controller;


import com.luv2code.ecommerce.entity.Country;
import com.luv2code.ecommerce.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api-countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        System.out.println("===>> Countries: " + countryService.getAllCountries());
        return countryService.getAllCountries();
    }

    @GetMapping("/countries/{id}")
    public Optional<Country> getCountryById(@PathVariable Integer id) {
        return countryService.getCountryById(id);
    }


}
