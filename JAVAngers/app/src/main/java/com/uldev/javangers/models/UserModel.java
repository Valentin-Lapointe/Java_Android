package com.uldev.javangers.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class UserModel {

    // Parametres
    public int id;
    public Date creationDate;
    public String login;
    public String password;
    public Integer administrationRight = null;
    public Date lastModificationDate = null;
    public Integer id_Civil = null;

    //Constructeur
    public UserModel(){

    }

    public UserModel(ResultSet result) throws SQLException {
        this.id = result.getInt("Id");
        this.creationDate = result.getDate("CreationDate");
        this.login = result.getString("Login");
        this.password = result.getString("Password");
        this.administrationRight = result.getInt("AdministrationRight");
        this.lastModificationDate = result.getDate("LastModificationDate");
        this.id_Civil = result.getInt("FK_Civil");

    }

}
