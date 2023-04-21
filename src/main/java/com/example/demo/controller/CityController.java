package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.service.city.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CityController {

    @Autowired
    ICityService cityService;

    @GetMapping("/")
    public ModelAndView getAllCity() {
        Iterable<City> city = cityService.findAll();
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("city", city);
        return modelAndView;
    }

}
