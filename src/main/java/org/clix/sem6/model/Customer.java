package org.clix.sem6.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String postalCode;
    private String firstName;
    private String secondName;
    private String firstSurname;
    private String secondSurname;
    private String city;
    private String materialStatus;
    private String salary;

}
