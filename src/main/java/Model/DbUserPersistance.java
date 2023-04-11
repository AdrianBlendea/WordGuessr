package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class DbUserPersistance {

    public DbUserPersistance() {

    }
    public static ArrayList<User> findAll()
    {

        String query = "SELECT idUser,username,guessed,firstTry,inarow,found,descriere  FROM user";
        return executeQuery(query);

    }
    public static User findUser(String query)
    {
        User check=null ;
        Connection connection = ConnectionFactory.createConnection();

        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet rs=statement.executeQuery(query);
            while(rs.next())
            {
                int id = rs.getInt(1);
                String user = rs.getString(2);
                int guessed =rs.getInt(3);
                int firstTry = rs.getInt(4);
                int inarow = rs.getInt(5);
                int found = rs.getInt(6);
                String descriere = rs.getString(7);



                check= new User(id,user, guessed,firstTry,inarow,found,descriere);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return check;
    }


    public static User checkUser (String username, String password)
    {
        String query = "SELECT idUser,username, guessed,firstTry,inarow,found,descriere FROM user WHERE username = '" + username + "' AND password = '" + password + "'";
        return findUser(query);
    }
    public static User findByUsername(String username)
    {
        String query = "SELECT idUser,username, guessed,firstTry,inarow,found,descriere FROM user WHERE username = '" + username +  "'";
       return  findUser(query);
    }
    public static String findWord(int id)
    {   Connection connection = ConnectionFactory.createConnection();
        String query = "SELECT word FROM user where idUser = " + id;
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet rs=statement.executeQuery(query);
            while(rs.next())
            return rs.getString(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
       return "";
    }

    public static void setWord(String word,int id,String descriere) {
        String query = "UPDATE user SET word ='" + word +"' ," + "descriere ='" +descriere +"'," +  "found=0 WHERE idUser =" + id;
        executeUpdates(query);

    }
    public static void updateWordsCount(int id,int number)
    {
        String query = "update user set guessed =" + "guessed" +"+"+ number  + " where idUser=" + id;
        System.out.println(query);
        executeUpdates(query);
    }
    public static void updateFirstTryBadges(int id,int number)
    {
        String query = "update user set firstTry =" + "firstTry" +"+"+ number  + " where idUser=" + id;
        executeUpdates(query);
    }

    public static void updateInARowBadges(int id,int number)
    {
        String query = "update user set inarow =" + "inarow" +"+"+ number  + " where idUser=" + id;
        executeUpdates(query);
    }

    public static void setFound(int id)
    {
        String query = "update user set found =" + 1  + " where idUser=" + id;
        System.out.println(query);
        executeUpdates(query);
    }

    public static ArrayList<User> executeQuery (String query)
    {
        ArrayList<User> users = new ArrayList<User>();
        Connection connection = ConnectionFactory.createConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet rs=statement.executeQuery(query);
            while(rs.next())
            {    int id = rs.getInt(1);
                String user = rs.getString(2);
                int guessed =rs.getInt(3);
                int firstTry = rs.getInt(4);
                int inarow = rs.getInt(5);
                int f = rs.getInt(6);
                String descriere = rs.getString(7);




                User found = new User(id,user, guessed,firstTry,inarow,f,descriere);

                users.add(found);


            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Collections.sort(users);
        return users;


    }

    public static void executeUpdates(String query)
    { Connection connection = ConnectionFactory.createConnection();

        Statement statement = null;

        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }




}





