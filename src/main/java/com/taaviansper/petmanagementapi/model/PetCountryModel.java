package com.taaviansper.petmanagementapi.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "pet_country")
public class PetCountryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "country")
    private String Country;

    public PetCountryModel() {}

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        this.Country = country;
    }


    @Override
    public String toString(){
        return "PetCountryModel{" + "id=" + Id + ", country=" + Country + '}';
    }
}
