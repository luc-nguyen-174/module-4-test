package com.example.demo.service.country;

import com.example.demo.model.Country;
import com.example.demo.repo.CountryRepository;
import com.example.demo.service.IGeneral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CountryService implements ICountryService {
    @Autowired
    private CountryRepository countryRepository;
    @Override
    public Iterable findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return countryRepository.findById(id);
    }

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public void remove(Long id) {
        countryRepository.deleteById(id);
    }
}
