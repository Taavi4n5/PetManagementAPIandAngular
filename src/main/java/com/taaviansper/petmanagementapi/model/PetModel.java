package com.taaviansper.petmanagementapi.model;

import jakarta.persistence.*;


@Entity
@Table(name = "pets")
public class PetModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String Name;
    private Long Code;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    private PetTypeModel Type;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fur_colour_id")
    private PetFurColourModel FurColour;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private PetCountryModel Country;
    public PetModel() {}

    public PetModel(Integer Id, String Name, Long Code, PetTypeModel Type, PetFurColourModel FurColour, PetCountryModel Country) {
        this.Id = Id;
        this.Name = Name;
        this.Code = Code;
        this.Type = Type;
        this.FurColour = FurColour;
        this.Country = Country;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Long getCode() {
        return Code;
    }

    public void setCode(Long code) {
        Code = code;
    }
    public PetTypeModel getType() {
        return Type;
    }

    public void setType(PetTypeModel type) {
        Type = type;
    }

    public PetFurColourModel getFurColour() {
        return FurColour;
    }

    public void setFurColour(PetFurColourModel furColour) {
        FurColour = furColour;
    }

    public PetCountryModel getCountry() {
        return Country;
    }

    public void setCountry(PetCountryModel country) {
        Country = country;
    }

    @Override
    public String toString() {
        return "PetModel{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Code='" + Code + '\'' +
                ", Type='" + Type + '\'' +
                ", FurColour='" + FurColour + '\'' +
                ", Country='" + Country + '\'' +
                '}';
    }
}
