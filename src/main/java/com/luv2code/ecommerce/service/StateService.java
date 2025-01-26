package com.luv2code.ecommerce.service;


import com.luv2code.ecommerce.dao.StateRepository;
import com.luv2code.ecommerce.entity.State;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class StateService {


    @Autowired
    private StateRepository stateRepository;




    public List<State> getAllStates() {
        return stateRepository.findAll();
    }

    public List<State> getStatesByCountryId(int id) {
        return stateRepository.findStatesByCountryId(id);
    }




}
