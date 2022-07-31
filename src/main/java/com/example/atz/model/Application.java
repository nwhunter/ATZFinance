package com.example.atz.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "application")
public class Application implements Serializable  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long appId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "SSN")
    private String SSN;
    @Column(name = "loan_amount")
    private String loanAmount;
    @Column(name = "purpose")
    private String loanPurpose;

    //Getters and Setter for APPLICATION

}