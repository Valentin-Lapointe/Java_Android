package com.uldev.javangers.models;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class MissionModel implements Serializable {

    // Parametres
    public int id;
    public Date creationDate;
    public String title;
    public Date endDate;
    public Integer urgency = null;
    public Boolean isSuccessful; // public Integer isSuccessful = null;
    public String comment;
    public Date lastModificationDate = null;
    public Integer id_Incident = null;
    public Integer id_Mesure = null;
    public Integer id_Itenerary = null;
    public Integer id_Seriousness = null;
    public Integer id_Admin = null;


    //Constructeur
    public MissionModel(){

    }

    public MissionModel(ResultSet result) throws SQLException {
        this.id = result.getInt("Id");
        this.creationDate = result.getDate("CreationDate");
        this.title = result.getString("Title");
        this.endDate = result.getDate("EndDate");
        this.urgency = result.getInt("Urgency");
        this.isSuccessful = result.getBoolean("IsSuccessful");
        this.comment = result.getString("Comment");
        this.lastModificationDate = result.getDate("LastModificationDate");
        this.id_Incident = result.getInt("FK_Incident");
        this.id_Mesure = result.getInt("FK_Mesure");
        this.id_Itenerary = result.getInt("FK_Itenerary");
        this.id_Seriousness = result.getInt("FK_Seriousness");
        this.id_Admin = result.getInt("FK_Admin");

    }@Override
    public String toString(){
        return this.title;
    }



}
