package com.taaviansper.petmanagementapi.service;

import com.taaviansper.petmanagementapi.DTO.PetDTO;
import com.taaviansper.petmanagementapi.model.PetCountryModel;
import com.taaviansper.petmanagementapi.model.PetFurColourModel;
import com.taaviansper.petmanagementapi.model.PetModel;
import com.taaviansper.petmanagementapi.model.PetTypeModel;
import com.taaviansper.petmanagementapi.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    @Autowired
    private PetRepository pr;

    public List<PetDTO> readAllPets() {
        return pr.findAllPets();
    }

    public PetDTO readById(Integer Id) {
        Optional<PetDTO> tmp = pr.findPetById(Id);
        final PetDTO[] petdto = {null};
        tmp.ifPresent(petDTO -> petdto[0] = petDTO);
        return petdto[0];
    }

    public PetModel addPet(PetDTO petDTO) {
        // Fetch the pet type entity by type
        PetTypeModel petType = pr.findPetTypeByType(petDTO.getType())
                .orElseThrow(() -> new IllegalArgumentException("Invalid pet type."));

        // Fetch the pet fur colour entity by colour
        PetFurColourModel petFurColour = pr.findPetFurColourByColour(petDTO.getFurColour())
                .orElseThrow(() -> new IllegalArgumentException("Invalid fur colour."));

        // Fetch the pet country entity by country name
        PetCountryModel petCountry = pr.findPetCountryByCountry(petDTO.getCountry())
                .orElseThrow(() -> new IllegalArgumentException("Invalid country."));


        // Create a new pet entity
        PetModel pet = new PetModel();
        pet.setName(petDTO.getName());
        pet.setCode(petDTO.getCode());
        pet.setType(petType);
        pet.setFurColour(petFurColour);
        pet.setCountry(petCountry);

        // Save the new pet entity to the database
        return pr.save(pet);
    }

    public PetModel updatePet(Integer id, PetDTO petDTO) {
        // Fetch the existing pet entity from the database by its id
        PetModel pet = pr.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid pet ID."));

        // Update the pet entity with the values from the request
        pet.setName(petDTO.getName());
        pet.setCode(petDTO.getCode());

        // Fetch the updated pet type entity by type
        PetTypeModel petType = pr.findPetTypeByType(petDTO.getType())
                .orElseThrow(() -> new IllegalArgumentException("Invalid pet type."));
        pet.setType(petType);

        // Fetch the updated pet fur colour entity by colour
        PetFurColourModel petFurColour = pr.findPetFurColourByColour(petDTO.getFurColour())
                .orElseThrow(() -> new IllegalArgumentException("Invalid fur colour."));
        pet.setFurColour(petFurColour);

        // Fetch the updated pet country entity by country name
        PetCountryModel petCountry = pr.findPetCountryByCountry(petDTO.getCountry())
                .orElseThrow(() -> new IllegalArgumentException("Invalid country."));
        pet.setCountry(petCountry);

        // Save the updated pet entity to the database
        return pr.save(pet);
    }

    public void deletePet(Integer id) {
        pr.deleteById(id);
    }

    public List<PetTypeModel> findAllTypes() {
        return pr.findAllTypes();
    }

    public List<PetFurColourModel> findAllColours() {
        return pr.findAllColours();
    }

    public List<PetCountryModel> findAllCountries() {
        return pr.findAllCountries();
    }

}
