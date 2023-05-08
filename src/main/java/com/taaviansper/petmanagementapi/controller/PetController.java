package com.taaviansper.petmanagementapi.controller;
import com.taaviansper.petmanagementapi.DTO.PetDTO;
import com.taaviansper.petmanagementapi.model.PetCountryModel;
import com.taaviansper.petmanagementapi.model.PetFurColourModel;
import com.taaviansper.petmanagementapi.model.PetModel;
import com.taaviansper.petmanagementapi.model.PetTypeModel;
import com.taaviansper.petmanagementapi.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200") // This is to allow the Angular app to access the API
@RestController
@RequestMapping("/api/pets")
public class PetController {
    @Autowired
    private PetService ps;

    // Get requests
    @GetMapping
        public List<PetDTO> GetAllPets() {
        return ps.readAllPets();
    }

    @GetMapping("/{id}")
        public PetDTO GetPetById(@PathVariable("id") Integer id) {
        return ps.readById(id);
    }

    @GetMapping("/pet-types")
    public List<PetTypeModel> getPetTypes() {
        return ps.findAllTypes();
    }

    @GetMapping("/pet-colours")
    public List<PetFurColourModel> getPetColours() {
        return ps.findAllColours();
    }

    @GetMapping("/pet-countries")
    public List<PetCountryModel> getPetCountries() {
        return ps.findAllCountries();
    }

    // Post requests
    @PostMapping
    public PetModel AddPet(@RequestBody PetDTO petDTO) {
        return ps.addPet(petDTO);
    }

    // Put requests
    @PutMapping("/{id}")
    public PetModel updatePet(@PathVariable Integer id, @RequestBody PetDTO petDTO) {
        return ps.updatePet(id, petDTO);
    }

    // Delete requests
    @DeleteMapping("/{id}")
        public void DeletePet(@PathVariable("id") Integer id) {
        ps.deletePet(id);
    }

}
