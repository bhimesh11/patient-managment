package com.pm.patientservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    @Email
    @Column(unique = true)
    private String email;
    @NotNull
    private String address;



    @NotNull
    private LocalDate dateOfBirth;
    @NotNull
    private LocalDate registerDate;

    public Patient(LocalDate registerDate, LocalDate dateOfBirth, String address, String email, String name, UUID id) {
        this.registerDate = registerDate;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.email = email;
        this.name = name;
        this.id = id;
    }

    public Patient() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public @NotNull String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        this.name = name;
    }

    public @NotNull @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotNull @Email String email) {
        this.email = email;
    }

    public @NotNull String getAddress() {
        return address;
    }

    public void setAddress(@NotNull String address) {
        this.address = address;
    }

    public @NotNull LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(@NotNull LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public @NotNull LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(@NotNull LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", registerDate=" + registerDate +
                '}';
    }
}
