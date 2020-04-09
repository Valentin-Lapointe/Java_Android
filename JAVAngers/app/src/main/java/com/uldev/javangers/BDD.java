package com.uldev.javangers;
import android.os.AsyncTask;

import com.uldev.javangers.models.IncidentModel;
import com.uldev.javangers.models.UserModel;

import java.net.URL;
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
    String comment = "";
    Integer status = null;
    Integer fkcivil = null;
    String location = "";
    Integer userID = null;

    UserModel user = null;
    List<IncidentModel> incidents = null;


    protected void request() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("toto");
        }
        String url = "jdbc:mysql://mysql-valentin-lapointe.alwaysdata.net:3306/valentin-lapointe_java_android?autoReconnect=true";
        String user = "170323_ugo";
        String passwd = "CHz93r3K3uUnyEPhP8Bf";

        Connection conn = null;
        try {
            /* Initializing the connection */
            conn = DriverManager.getConnection(url, user, passwd);

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

    protected void foundcivilbyuser(Integer UserId) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("toto");
        }
        String url = "jdbc:mysql://mysql-valentin-lapointe.alwaysdata.net:3306/valentin-lapointe_java_android?autoReconnect=true";
        String user = "170323_ugo";
        String passwd = "CHz93r3K3uUnyEPhP8Bf";

        Connection conn = null;
        try {
            /* Initializing the connection */
            conn = DriverManager.getConnection(url, user, passwd);

            Statement statement = conn.createStatement();

            ResultSet resultset = statement.executeQuery("SELECT * FROM t_User WHERE Id=" + UserId.toString());
            while (resultset.next()) {
                fkcivil = resultset.getInt(7);
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

    protected void createdemande(String comment, Integer status, Integer fkcivil) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("toto");
        }
        String url = "jdbc:mysql://mysql-valentin-lapointe.alwaysdata.net:3306/valentin-lapointe_java_android?autoReconnect=true";
        String user = "170323_ugo";
        String passwd = "CHz93r3K3uUnyEPhP8Bf";

        Connection conn = null;
        try {
            /* Initializing the connection */
            conn = DriverManager.getConnection(url, user, passwd);

            Statement statement = conn.createStatement();

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();

            statement.executeUpdate("INSERT INTO t_Incident (Comment, Status, FK_Civil, CreationDate, LastModificationDate) VALUES ('" + comment + "', " + status + ", " + fkcivil + ", '"+ dateFormat.format(date) +"', '"+ dateFormat.format(date) +"')");

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
            Connection conn =  DriverManager.getConnection(url, user, passwd);
            return conn;
        } catch (SQLException e) {
            System.out.println("SQL connection error: " + e.getMessage());
            return null;
        }
    }

    protected void signIn(String login, String password) {
        try {
            Statement statement = dbConnection().createStatement();
            try {
                String sql = "SELECT * FROM t_User WHERE Login= '"+ login + "' AND Password= '"+ password +"'";
                ResultSet result = statement.executeQuery(sql);

                while (result.next()) {
                    user = new UserModel(result);
                    System.out.println(user.login);
                    System.out.println(user.creationDate);
                }
            } catch (Exception ex) {
                System.out.println("debug : " + ex.getMessage());
            } finally {
                statement.close();
            }
        }catch (Exception e){
            System.out.println("bug :" + e.getMessage());
        }
    }

    protected void signUp(String login, String password) {
        try {
            //on se connecte a la BDD
            Statement statement = dbConnection().createStatement();
            try {

                //on recupere la date actuelle pour l'enregistrer en BDD
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date();

                // on crée la chaine SQL avec les valeurs recuprer des champs de l'application
                String sql = "INSERT INTO t_User (CreationDate, Login, Password, AdministrationRight) VALUES ('"+dateFormat.format(date)+"', '"+login+"', '"+password+"', '0')";
                //on envoie la requete a la BDD pour inscrire l'utilisateur
                statement.executeUpdate(sql);

            } catch (Exception ex) {
                 System.out.println("debug : " + ex.getMessage());
            } finally {
                statement.close();
            }
        }catch (Exception e){
            System.out.println("bug :" + e.getMessage());
        }
    }

    protected void listIncidents(){
        try {
            Connection conn = dbConnection();
            Statement statement = conn.createStatement();
            try {
                incidents = new ArrayList<>();
                String sql = "SELECT * FROM t_Incident";
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
        }catch (Exception e){
            System.out.println("bug :" + e.getMessage());
        }
    }

//    protected void getIncidentById(int id) {
//        try {
//            Connection conn = dbConnection();
//            Statement statement = conn.createStatement();
//            try {
//                String sql = "SELECT * FROM t_Civil WHERE Id="+ user.id_Civil;
//                ResultSet resultCivil = statement.executeQuery(sql);
//                while (resultCivil.next()) {
//                    civil = new CivilModel(resultCivil);
//                }
//            } catch (Exception ex) {
//                System.out.println("debug : " + ex.getMessage());
//            } finally {
//                statement.close();
//                conn.close();
//            }
//        }catch (Exception e){
//            System.out.println("bug :" + e.getMessage());
//        }
//    }

    @Override
    protected Long doInBackground(String... functions) {
        for (String function : functions) {
            System.out.println(function);
            if (function.equals("request")){
                request();
            }
            if (function.equals("createdemande")){
                createdemande(comment, status, fkcivil);
            }
            if (function.equals("foundcivilbyuser")){
                foundcivilbyuser(userID);
            }
            if (function.equals("signIn")){
                signIn(login, password);
            }
            if (function.equals("signUp")){
                signUp(login, password);
            }
            if (function.equals("listIncidents")){
                listIncidents();
            }
        }
        return null;
    }
}