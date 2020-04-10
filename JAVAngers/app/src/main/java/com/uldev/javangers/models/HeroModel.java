package com.uldev.javangers.models;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class HeroModel implements Serializable {

    // Parametres
    public int id ;
    public Date creationDate;
    public String alias;
    public boolean isSuperHero;
    public String comment;
    public Date deathDate = null;
    public Date lastModificationDate = null;
    public Integer id_Civil = null;

    //Constructeur
    public HeroModel(){

    }

    public HeroModel(ResultSet result) throws SQLException {
        this.id = result.getInt("Id");
        this.creationDate = result.getDate("CreationDate");
        this.alias = result.getString("Alias");
        this.isSuperHero = result.getBoolean("IsSuperHero");
        this.comment = result.getString("Comment");
        this.deathDate = result.getDate("DeathDate");
        this.lastModificationDate = result.getDate("LastModificationDate");
        this.id_Civil = result.getInt("FK_Civil");

    }
}
