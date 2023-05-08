package com.taaviansper.petmanagementapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pet_type")
public class PetTypeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "type")
    private String Type;

    public PetTypeModel() {}

    public PetTypeModel(Integer id, String type) {
        this.Id = id;
        this.Type = type;
    }

    public PetTypeModel(Integer id) {
        this.Id = id;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        this.Id = id;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        this.Type = type;
    }

    @Override
    public String toString(){
        return "PetTypeModel{" + "id=" + Id + ", type=" + Type + '}';
    }
}
