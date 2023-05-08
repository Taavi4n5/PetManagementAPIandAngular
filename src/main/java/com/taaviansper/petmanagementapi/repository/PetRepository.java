package com.taaviansper.petmanagementapi.repository;

import com.taaviansper.petmanagementapi.DTO.PetDTO;
import com.taaviansper.petmanagementapi.model.PetCountryModel;
import com.taaviansper.petmanagementapi.model.PetFurColourModel;
import com.taaviansper.petmanagementapi.model.PetModel;
import com.taaviansper.petmanagementapi.model.PetTypeModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<PetModel, Integer>{
    @Query ("SELECT new com.taaviansper.petmanagementapi.DTO.PetDTO" +
            "(p.Id, p.Name, p.Code, t.Type, f.FurColour, c.Country) " +
            "FROM PetModel p " +
            "JOIN p.Type t " +
            "JOIN p.FurColour f " +
            "JOIN p.Country c")
    List<PetDTO> findAllPets();

    @Query ("SELECT new com.taaviansper.petmanagementapi.DTO.PetDTO" +
            "(p.Id, p.Name, p.Code, t.Type, f.FurColour, c.Country) " +
            "FROM PetModel p " +
            "JOIN p.Type t " +
            "JOIN p.FurColour f " +
            "JOIN p.Country c "
            + "WHERE p.Id = :id")
    Optional<PetDTO> findPetById(@Param("id") Integer idDTO);

    // Query to fetch the PetTypeModel entity by its type property
    @Query("SELECT t FROM PetTypeModel t WHERE t.Type = :petType")
    Optional<PetTypeModel> findPetTypeByType(@Param("petType") String petType);

    // Query to fetch the PetFurColourModel entity by its FurColour property
    @Query("SELECT f FROM PetFurColourModel f WHERE f.FurColour = :petFurColour")
    Optional<PetFurColourModel> findPetFurColourByColour(@Param("petFurColour") String petFurColour);

    // Query to fetch the PetCountryModel entity by its Country property
    @Query("SELECT c FROM PetCountryModel c WHERE c.Country = :petCountry")
    Optional<PetCountryModel> findPetCountryByCountry(@Param("petCountry") String petCountry);
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO PetModel (Name, Code, Type, FurColour, Country) " +
            "SELECT :name, :code, t, f, c " +
            "FROM PetTypeModel t, PetFurColourModel f, PetCountryModel c " +
            "WHERE t.Type = :type AND f.FurColour = :furColour AND c.Country = :country", nativeQuery = true)
    PetModel addPet(@Param("name") String name, @Param("code") Long code,
                @Param("type") String Type, @Param("furColour") String furColour,
                @Param("country") String country);

    void deleteById(Integer id);

    @Query("SELECT p FROM PetTypeModel p")
    List<PetTypeModel> findAllTypes();

    @Query("SELECT f FROM PetFurColourModel f")
    List<PetFurColourModel> findAllColours();

    @Query("SELECT c FROM PetCountryModel c")
    List<PetCountryModel> findAllCountries();

}

