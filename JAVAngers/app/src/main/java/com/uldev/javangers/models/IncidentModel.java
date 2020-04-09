package com.uldev.javangers.models;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class IncidentModel implements Serializable {

    // Parametres
    public int id;
    public Date creationDate;
    public String comment;
    public Integer status = null;
    public Date lastModificationDate = null;
    public Integer id_Civil = null;

    //Constructeur
    public IncidentModel(){

    }

    public IncidentModel(ResultSet result) throws SQLException {
        this.id = result.getInt("Id");
        this.creationDate = result.getDate("CreationDate");
        this.comment = result.getString("Comment");
        this.status = result.getInt("Status");
        this.lastModificationDate = result.getDate("LastModificationDate");
        this.id_Civil = result.getInt("FK_Civil");

    }
}
