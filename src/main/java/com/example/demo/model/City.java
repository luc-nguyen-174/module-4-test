package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;


@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Size(max = 50)
    private String cityName;
    @Positive
    private Long acreage;
    @Positive
    private Long population;
    @Positive
    private Long GDP;
    private String information;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    @JsonIgnore //ngan lap vo han
    private Country country;

    public City() {
    }

    public City(String cityName, Long acreage, Long population, Long GDP, String information) {
        this.cityName = cityName;
        this.acreage = acreage;
        this.population = population;
        this.GDP = GDP;
        this.information = information;
    }

    public City(Long id, String cityName, Long acreage, Long population, Long GDP, String information, Country country) {
        this.id = id;
        this.cityName = cityName;
        this.acreage = acreage;
        this.population = population;
        this.GDP = GDP;
        this.information = information;
        this.country = country;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Long getAcreage() {
        return acreage;
    }

    public void setAcreage(Long acreage) {
        this.acreage = acreage;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Long getGDP() {
        return GDP;
    }

    public void setGDP(Long GDP) {
        this.GDP = GDP;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
