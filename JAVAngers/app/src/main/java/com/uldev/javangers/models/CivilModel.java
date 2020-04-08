package com.uldev.javangers.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class CivilModel {

    // Parametres
    public int id ;
    public Date creationDate;
    public String lastName;
    public String firstName;
    public Date birthDate = null;
    public Date deathDate = null;
    public String comment;
    public Date lastModificationDate = null;
    public Integer id_ContactInformation = null;

    //Constructeur
    public CivilModel(){

    }

    public CivilModel(ResultSet result) throws SQLException {
        this.id = result.getInt("Id");
        this.creationDate = result.getDate("CreationDate");
        this.lastName = result.getString("LastName");
        this.firstName = result.getString("FirstName");
        this.birthDate = result.getDate("BirthDate");
        this.deathDate = result.getDate("DeathDate");
        this.comment = result.getString("Comment");
        this.lastModificationDate = result.getDate("LastModificationDate");
        this.id_ContactInformation = result.getInt("FK_ContactInformation");

    }
}
