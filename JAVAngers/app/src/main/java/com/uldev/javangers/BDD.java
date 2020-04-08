package com.uldev.javangers;
import android.os.AsyncTask;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.lang.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BDD extends AsyncTask<String, Integer, Long> {

    //paramètres pour les fonctions
    String comment = "";
    Integer status = null;
    Integer fkcivil = null;
    String location = "";
    Integer userID = null;


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

    @Override
    protected Long doInBackground(String... functions) {
        for (String function : functions) {
            if (function.equals("request")){
                request();
            }
            if (function.equals("createdemande")){
                createdemande(comment, status, fkcivil);
            }
            if (function.equals("foundcivilbyuser")){
                foundcivilbyuser(userID);
            }
        }
        return null;
    }
}
