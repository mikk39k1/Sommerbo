package Database;

import java.sql.*;

public class DB_EditingHandler {

    public void insertIntoQuery(String table, String[] columns, DB_Dependencies db_dependencies){

        try (
                Connection connection = DriverManager.getConnection(
                        db_dependencies.DATABASE_URL,
                        db_dependencies.USERNAME,
                        db_dependencies.PASSWORD
                );

                Statement statement = connection.createStatement();
                )
        {
            String query = "INSERT INTO " + table + " (" + String.join(",", columns) + ") VALUES" +
                    " (" + String.join(",", columns) + ")";
            statement.executeQuery(query);

        } catch (SQLException e){
            System.out.println("SQLEXCEPTION: " + e);
        }

    }
}
