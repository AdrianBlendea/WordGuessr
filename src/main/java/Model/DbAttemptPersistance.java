package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbAttemptPersistance {
    public static void removeallAtempts(int id)
    {
        String query = "delete from attempt where idChallenge =" + id;

        DbUserPersistance.executeUpdates(query);
    }
    public static void addAttempt (int challenge,int challenger)
    {
        String query = "INSERT INTO attempt (`idChallenger`, `idChallenge`) VALUES ('"  + challenger + "" + "'," +"'" + challenge + "');";
        DbUserPersistance.executeUpdates(query);
    }
    public static int countPeoples(int challengeId)
    {
       String query =  "SELECT COUNT(DISTINCT idChallenger)  FROM attempt WHERE idChallenge=" + challengeId;
       return singleValueReturn(query);
    }


    public static int countTries (int challenge,int challenger)
    {
        String query = "SELECT count(*) FROM attempt where idChallenge = " + challenge + " AND idChallenger = " +challenger;
       return singleValueReturn(query);
    }
    public static int singleValueReturn (String query)
    {   Connection connection = ConnectionFactory.createConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet rs=statement.executeQuery(query);
            while(rs.next())
                return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }



}
