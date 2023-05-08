package com.taaviansper.petmanagementapi.model;


import jakarta.persistence.*;

@Entity
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

    public PetFurColourModel(Integer id, String FurColour) {
        this.Id = id;
        this.FurColour = FurColour;
    }

    public PetFurColourModel(Integer id) {
        this.Id = id;
    }

    @Override
    public String toString(){
        return "PetFurColourModel{" + "id=" + Id + ", colour=" + FurColour + '}';
    }
}
