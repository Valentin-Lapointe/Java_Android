package com.uldev.javangers.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class ContactInformationModel {

    // Parametres
    public int id ;
    public Date creationDate;
    public String lastName;
    public String firstName;
    public String Address1;
    public String Address2;
    public Integer ZipCode;
    public String City;
    public String PhoneNumber;
    public String Email;
    public Date lastModificationDate = null;
    public Integer id_Country = null;

    //Constructeur
    public ContactInformationModel(){

    }

    public ContactInformationModel(ResultSet result) throws SQLException {
        this.id = result.getInt("Id");
        this.creationDate = result.getDate("CreationDate");
        this.lastName = result.getString("LastName");
        this.firstName = result.getString("FirstName");
        this.Address1 = result.getString("Address1");
        this.Address2 = result.getString("Address2");
        this.ZipCode = result.getInt("ZipCode");
        this.City = result.getString("City");
        this.PhoneNumber = result.getString("PhoneNumber");
        this.Email = result.getString("Email");
        this.lastModificationDate = result.getDate("LastModificationDate");
        this.id_Country = result.getInt("FK_Country");

    }
}
