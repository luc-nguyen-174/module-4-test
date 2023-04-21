package com.example.demo.controller;

import com.example.demo.model.City;
import com.example.demo.model.Country;
import com.example.demo.service.city.ICityService;
import com.example.demo.service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/cities")
public class CityController {

    @Autowired
    ICityService cityService;

    @Autowired
    ICountryService countryService;

    @ModelAttribute("countries")
    public Iterable<Country> countries() {
        return countryService.findAll();
    }

    @GetMapping("/index")
    public ModelAndView getAllCity() {
        Iterable<City> city = cityService.findAll();
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("cities", city);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView addNewCity() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("cities", new City());
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute("cities") City city) {
        cityService.save(city);

        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("cities", new City());
        modelAndView.addObject("message", "New city added successfully. \nBack to list after 3s.");
        return modelAndView;
    }

    @GetMapping(value = "/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<City> city = cityService.findById(id);
        if (city.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/edit");
            modelAndView.addObject("city", city);
            return modelAndView;
        } else {
            return new ModelAndView("/error.404");
        }
    }

    @PostMapping(value = "/edit")
    public ModelAndView updateCity(@ModelAttribute("city") City city) {
        cityService.save(city);
        ModelAndView modelAndView = new ModelAndView("/edit");
        modelAndView.addObject("city", city);
        modelAndView.addObject("message", "City updated successfully. \nBack to list after 3s.");
        return modelAndView;
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable Long id) {
        cityService.remove(id);
        return "redirect:/cities/index";
    }

    @GetMapping("/view/{id}")
    public ModelAndView viewCity(@PathVariable("id") Long id) {
        Optional<City> city = cityService.findById(id);
        if (city.isEmpty()) {
            return new ModelAndView("/error.404");
        }
        ModelAndView modelAndView = new ModelAndView("/index");
        modelAndView.addObject("city", city);
        return modelAndView;
    }
}
