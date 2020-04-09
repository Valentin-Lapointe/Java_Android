package com.uldev.javangers;
import android.os.AsyncTask;

import com.uldev.javangers.models.IncidentModel;
import com.uldev.javangers.models.CivilModel;
import com.uldev.javangers.models.ContactInformationModel;
import com.uldev.javangers.models.MissionModel;
import com.uldev.javangers.models.UserModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.lang.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BDD extends AsyncTask<String, Integer, Long> {

    //paramètres pour les fonctions
    public static String password;
    public static String login;
    public static String nom;
    public static String prenom;
    public static String date_naissance;
    public static String adresse;
    public static String cp;
    public static String ville;
    public static String pays;
    public static String email;
    public static String telephone;
    public static Integer ID_USER;
    public static Integer ID_CIVIL;
    public Integer id_user;
    public Integer id_civil;
    String comment = "";
    Integer status = null;
    public static Integer fkcivil = null;
    String location = "";
    Integer userID = null;

    UserModel user = null;
    List<IncidentModel> incidents = null;
    CivilModel civil = null;
    MissionModel mission = null;


    protected void request() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("toto");
        }
        String url = "jdbc:mysql://mysql-valentin-lapointe.alwaysdata.net:3306/valentin-lapointe_java_android?autoReconnect=true";
        String userbdd = "170323_ugo";
        String passwd = "CHz93r3K3uUnyEPhP8Bf";

        Connection conn = null;
        try {
            /* Initializing the connection */
            conn = DriverManager.getConnection(url, userbdd, passwd);

            Statement statement = conn.createStatement();

            ResultSet resultset = statement.executeQuery("SELECT * FROM t_User WHERE Login='test'");
            while (resultset.next()) {
                System.out.println(resultset.getString(4));
            }
        } catch (SQLException e) {
            System.out.println("SQL connection error: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    /* CLosing connection */
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error while closing the connection: " + e.getMessage());
                }
            }
        }
    }

    protected Integer foundcivilbyuser(Integer UserId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("toto");
        }
        String url = "jdbc:mysql://mysql-valentin-lapointe.alwaysdata.net:3306/valentin-lapointe_java_android?autoReconnect=true";
        String userbdd = "170323_ugo";
        String passwd = "CHz93r3K3uUnyEPhP8Bf";

        Connection conn = null;
        try {
            /* Initializing the connection */
            conn = DriverManager.getConnection(url, userbdd, passwd);

            Statement statement = conn.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM t_User WHERE Id=" + UserId.toString());
            Integer fkciviltemp = null;
            while (resultset.next()) {
                fkciviltemp = resultset.getInt(7);
                if (fkciviltemp != null) {
                    fkcivil = fkciviltemp;
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL connection error: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    /* CLosing connection */
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error while closing the connection: " + e.getMessage());
                }
            }
            return fkcivil;
        }
    }

    protected void createdemande(String comment, Integer status, Integer fkcivil) {
        fkcivil = foundcivilbyuser(userID);

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("toto");
        }
        String url = "jdbc:mysql://mysql-valentin-lapointe.alwaysdata.net:3306/valentin-lapointe_java_android?autoReconnect=true";
        String userbdd = "170323_ugo";
        String passwd = "CHz93r3K3uUnyEPhP8Bf";
        Integer fkcivil2 = fkcivil;

        Connection conn = null;
        try {
            /* Initializing the connection */
            conn = DriverManager.getConnection(url, userbdd, passwd);

            Statement statement = conn.createStatement();

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();

            statement.executeUpdate("INSERT INTO t_Incident (Comment, Status, FK_Civil, CreationDate, LastModificationDate) VALUES ('" + comment + "', " + 1 + ", " + fkcivil + ", '" + dateFormat.format(date) + "', '" + dateFormat.format(date) + "')");
        } catch (SQLException e) {
            System.out.println("SQL connection error: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    /* CLosing connection */
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error while closing the connection: " + e.getMessage());
                }
            }
        }
    }

    protected Connection dbConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        String url = "jdbc:mysql://mysql-valentin-lapointe.alwaysdata.net:3306/valentin-lapointe_java_android?autoReconnect=true";
        String user = "170323_ugo";
        String passwd = "CHz93r3K3uUnyEPhP8Bf";
        try {
            Connection conn = DriverManager.getConnection(url, user, passwd);
            return conn;
        } catch (SQLException e) {
            System.out.println("SQL connection error: " + e.getMessage());
            return null;
        }
    }

    protected void signIn(String login, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("toto");
        }
        String url = "jdbc:mysql://mysql-valentin-lapointe.alwaysdata.net:3306/valentin-lapointe_java_android?autoReconnect=true";
        String userbdd = "170323_ugo";
        String passwd = "CHz93r3K3uUnyEPhP8Bf";

        Connection conn = null;
        try {
            /* Initializing the connection */
            conn = DriverManager.getConnection(url, userbdd, passwd);

            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM t_User WHERE Login= '" + login + "' AND Password= '" + password + "'";
            ResultSet result = statement.executeQuery(sql);

            while (result.next()) {
                user = new UserModel(result);
            }

            getCivilById(user.id_Civil);


        } catch (SQLException e) {
            System.out.println("SQL connection error: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    /* CLosing connection */
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error while closing the connection: " + e.getMessage());
                }
            }
        }
    }

    protected Integer signUp(String login, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("toto");
        }
        String url = "jdbc:mysql://mysql-valentin-lapointe.alwaysdata.net:3306/valentin-lapointe_java_android?autoReconnect=true";
        String userbdd = "170323_ugo";
        String passwd = "CHz93r3K3uUnyEPhP8Bf";

        Connection conn = null;
        try {
            /* Initializing the connection */
            conn = DriverManager.getConnection(url, userbdd, passwd);

            Statement statement = conn.createStatement();

            //on recupere la date actuelle pour l'enregistrer en BDD
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();

            // on crée la chaine SQL avec les valeurs recuprer des champs de l'application
            String sql = "INSERT INTO t_User (CreationDate, Login, Password, AdministrationRight) VALUES ('" + dateFormat.format(date) + "', '" + login + "', '" + password + "', '0')";
            //on envoie la requete a la BDD pour inscrire l'utilisateur
            statement.executeUpdate(sql);

            String sql_2 = "SELECT * FROM t_User WHERE id= LAST_INSERT_ID()";
            ResultSet User = statement.executeQuery(sql_2);
            UserModel user = null;
            while (User.next()) {
                user = new UserModel(User);
            }
            id_user = user.id;
            return id_user;

        } catch (SQLException e) {
            System.out.println("SQL connection error: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    /* CLosing connection */
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error while closing the connection: " + e.getMessage());
                }
            }
        }
        return 0;
    }

    protected Integer insertCivil(String nom, String prenom, String date_naissance, int ID_USER) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("toto");
        }
        String url = "jdbc:mysql://mysql-valentin-lapointe.alwaysdata.net:3306/valentin-lapointe_java_android?autoReconnect=true";
        String userbdd = "170323_ugo";
        String passwd = "CHz93r3K3uUnyEPhP8Bf";

        Connection conn = null;
        try {
            /* Initializing the connection */
            conn = DriverManager.getConnection(url, userbdd, passwd);

            Statement statement = conn.createStatement();
            try {

                //on recupere la date actuelle pour l'enregistrer en BDD
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date();

                // on crée la chaine SQL avec les valeurs recuprer des champs de l'application
                String sql = "INSERT INTO t_Civil (CreationDate, LastName, FirstName, BirthDate) VALUES ('" + dateFormat.format(date) + "', '" + nom + "', '" + prenom + "', '" + date_naissance + "')";
                //on envoie la requete a la BDD pour terminer l'inscription de l'utilisateur
                statement.executeUpdate(sql);

                //on recupere l'id du civil pour l'enregistrer plus tard dans la table user
                String sql_2 = "SELECT * FROM t_Civil WHERE id= LAST_INSERT_ID()";
                ResultSet Civil = statement.executeQuery(sql_2);
                CivilModel civil = null;
                while (Civil.next()) {
                    civil = new CivilModel(Civil);
                }
                // on crée la chaine SQL avec les valeurs recuprer des champs de l'application
                String sql_3 = "UPDATE t_User SET LastModificationDate='" + dateFormat.format(date) + "', FK_Civil='" + civil.id + "' WHERE id ='" + ID_USER + "'";
                //on envoie la requete a la BDD pour terminer l'inscription de l'utilisateur
                statement.executeUpdate(sql_3);

                id_civil = civil.id;
                return id_civil;

            } catch (Exception ex) {
                System.out.println("debug : " + ex.getMessage());
            } finally {
                statement.close();
            }
        } catch (Exception e) {
            System.out.println("bug :" + e.getMessage());
        }
        return 0;
    }

    protected void insertContact(String adresse, String cp, String ville, String pays, String email, String telephone, int ID_CIVIL) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("toto");
        }
        String url = "jdbc:mysql://mysql-valentin-lapointe.alwaysdata.net:3306/valentin-lapointe_java_android?autoReconnect=true";
        String userbdd = "170323_ugo";
        String passwd = "CHz93r3K3uUnyEPhP8Bf";

        Connection conn = null;
        try {
            /* Initializing the connection */
            conn = DriverManager.getConnection(url, userbdd, passwd);

            Statement statement = conn.createStatement();
            try {

                //on recupere la date actuelle pour l'enregistrer en BDD
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date();

                //on recupere l'id du civil pour l'enregistrer plus tard dans la table user
                String sql = "SELECT * FROM t_Civil WHERE id='" + ID_CIVIL + "'";
                ResultSet Civil = statement.executeQuery(sql);
                CivilModel civil = null;
                while (Civil.next()) {
                    civil = new CivilModel(Civil);
                }
                // on crée la chaine SQL avec les valeurs recuprer des champs de l'application
                String sql_2 = "INSERT INTO t_ContactInformation (CreationDate, LastName, FirstName, Address1, ZipCode, City, FK_Country, PhoneNumber, Email) VALUES ('" + dateFormat.format(date) + "', '" + civil.lastName + "', '" + civil.firstName + "', '" + adresse + "', '" + cp + "', '" + ville + "', '1', '" + telephone + "', '" + email + "')";
                //on envoie la requete a la BDD pour enregistrer les information de contact de l'utilisateur
                statement.executeUpdate(sql_2);

                //on recupere l'id du civil pour l'enregistrer plus tard dans la table user
                String sql_3 = "SELECT * FROM t_ContactInformation WHERE id= LAST_INSERT_ID()";
                ResultSet Contact = statement.executeQuery(sql_3);
                ContactInformationModel contact = null;
                while (Contact.next()) {
                    contact = new ContactInformationModel(Contact);
                }
                // on crée la chaine SQL avec les valeurs recuprer des champs de l'application
                String sql_4 = "UPDATE t_Civil SET LastModificationDate='" + dateFormat.format(date) + "', FK_ContactInformation='" + contact.id + "' WHERE id ='" + ID_CIVIL + "'";
                //on envoie la requete a la BDD pour terminer l'inscription de l'utilisateur
                statement.executeUpdate(sql_4);


            } catch (Exception ex) {
                System.out.println("debug : " + ex.getMessage());
            } finally {
                statement.close();
            }
        } catch (Exception e) {
            System.out.println("debug : " + e.getMessage());
        }
    }

    protected void listIncidents() {
        try {
            Connection conn = dbConnection();
            Statement statement = conn.createStatement();
            try {
                incidents = new ArrayList<>();
                String sql = "SELECT * FROM t_Incident ORDER BY CreationDate DESC";
                ResultSet result = statement.executeQuery(sql);

                while (result.next()) {
                    IncidentModel incident = new IncidentModel(result);
                    incidents.add(incident);
                }
            } catch (Exception ex) {
                System.out.println("debug : " + ex.getMessage());
            } finally {
                statement.close();
                conn.close();
            }
        } catch (Exception e) {
            System.out.println("bug :" + e.getMessage());
        }
    }

    protected void getCivilById(int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("toto");
        }
        String url = "jdbc:mysql://mysql-valentin-lapointe.alwaysdata.net:3306/valentin-lapointe_java_android?autoReconnect=true";
        String userbdd = "170323_ugo";
        String passwd = "CHz93r3K3uUnyEPhP8Bf";

        Connection conn = null;
        try {
            /* Initializing the connection */
            conn = DriverManager.getConnection(url, userbdd, passwd);

            Statement statement = conn.createStatement();
            String sql = "SELECT * FROM t_Civil WHERE Id=" + user.id_Civil;
            ResultSet resultCivil = statement.executeQuery(sql);

            while (resultCivil.next()) {
                civil = new CivilModel(resultCivil);
            }
        } catch (SQLException e) {
            System.out.println("SQL connection error: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    /* CLosing connection */
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error while closing the connection: " + e.getMessage());
                }
            }
        }
    }

    @Override
    protected Long doInBackground(String... functions) {
        for (String function : functions) {
            System.out.println(function);
            if (function.equals("request")) {
                request();
            }
            if (function.equals("createdemande")) {
                createdemande(comment, status, fkcivil);
            }
            if (function.equals("foundcivilbyuser")) {
                foundcivilbyuser(userID);
            }
            if (function.equals("signIn")) {
                signIn(login, password);
            }
            if (function.equals("signUp")) {
                signUp(login, password);
            }
            if (function.equals("listIncidents")) {
                listIncidents();
            }
            if (function.equals("insertCivil")) {
                insertCivil(nom, prenom, date_naissance, ID_USER);
            }
            if (function.equals("insertContact")) {
                insertContact(adresse, cp, ville, pays, email, telephone, ID_CIVIL);
            }
        }
        return null;
    }
}