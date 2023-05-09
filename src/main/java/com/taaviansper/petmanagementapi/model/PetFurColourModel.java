package com.taaviansper.petmanagementapi.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "pet_fur_colour")
public class PetFurColourModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "fur_colour")
    private String FurColour;

    public PetFurColourModel() {}

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public String getFurColour() {
        return FurColour;
    }

    public void setFurColour(String colour) {
        this.FurColour = FurColour;
    }

    @Override
    public String toString(){
        return "PetFurColourModel{" + "id=" + Id + ", colour=" + FurColour + '}';
    }
}
