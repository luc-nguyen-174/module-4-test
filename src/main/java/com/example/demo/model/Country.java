package com.example.demo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String country;

    @OneToMany(targetEntity = City.class, fetch = FetchType.EAGER)
    private List<City> cities;

    public Country() {
    }

    public Country(String country) {
        this.country = country;
    }

    public Country(Long id, String country) {
        this.id = id;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}
