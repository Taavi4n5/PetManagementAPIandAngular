package com.taaviansper.petmanagementapi.DTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class PetDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDTO;
    private String nameDTO;
    private Long codeDTO;
    private String typeDTO;
    private String furColourDTO;
    private String countryDTO;


    public PetDTO(Integer iddto, String namedto, Long codedto, String typedto, String furcolourdto, String countrydto) {
        this.idDTO = iddto;
        this.nameDTO = namedto;
        this.codeDTO = codedto;
        this.typeDTO = typedto;
        this.furColourDTO = furcolourdto;
        this.countryDTO = countrydto;

    }


    public Integer getId() {
        return idDTO;
    }

    public void setId(Integer iddto) {
        this.idDTO = iddto;
    }
    public String getName() {
        return nameDTO;
    }

    public void setName(String namedto) {
        this.nameDTO = namedto;
    }

    public Long getCode() {
        return codeDTO;
    }

    public void setCode(Long codedto) {
        this.codeDTO = codedto;
    }

    public String getType() {
        return typeDTO;
    }

    public void setType(String typedto) {
        this.typeDTO = typedto;
    }

    public String getFurColour() {
        return furColourDTO;
    }

    public void setFurColour(String furcolourdto) {
        this.furColourDTO = furcolourdto;
    }

    public String getCountry() {
        return countryDTO;
    }

    public void setCountry(String countrydto) {
        this.countryDTO = countrydto;
    }
}
