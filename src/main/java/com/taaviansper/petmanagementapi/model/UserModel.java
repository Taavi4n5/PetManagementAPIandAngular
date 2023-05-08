package com.taaviansper.petmanagementapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    @Column(name = "name")
    private String Name;

    @Column(name = "password")
    private String Password;

    public UserModel() {}

    public UserModel(Integer Id, String Name, String Password) {
        this.Id = Id;
        this.Name = Name;
        this.Password = Password;
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

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }


    @Override
    public String toString() {
        return "PetModel{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
