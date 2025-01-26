package com.luv2code.ecommerce.controller;


import com.luv2code.ecommerce.entity.State;
import com.luv2code.ecommerce.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api-states")
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping("/states")
    public List<State> getAllStates() {
        return stateService.getAllStates();
    }

    @GetMapping("/statesByCountryId/{id}")
    public List<State> getStatesByCountryId(@PathVariable Integer id) {
        return stateService.getStatesByCountryId(id);
    }


}
