package com.taaviansper.petmanagementapi.repository;

import com.taaviansper.petmanagementapi.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer>{
    @Query("SELECT u FROM UserModel u WHERE u.Name = :username")
    Optional<UserModel> findByName(String username);

}
