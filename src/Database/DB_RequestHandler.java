package Database;

import Menu.MenuController;

import java.sql.*;

public class DB_RequestHandler {


    public void queryRequest(DB_Dependencies db_dependencies,String query){
        try (
             Connection connection = DriverManager.getConnection(
             db_dependencies.DATABASE_URL,
             db_dependencies.USERNAME,
             db_dependencies.PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query);
            ){
            System.out.println(resultSet);
        } catch (SQLException e){
            System.out.println("SQLEXPECTION: " + e);
        }
    }

    public boolean checkLoginInfo(DB_Dependencies db_dependencies, String query, String username, String password) {

        try (
                Connection connection = DriverManager.getConnection(
                        db_dependencies.DATABASE_URL,
                        db_dependencies.USERNAME,
                        db_dependencies.PASSWORD);
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
        )
            {
                while (resultSet.next()) {
                    if (resultSet.getString(MenuController.inEmployeeMenu ? "employee_username" : "renter_username").equals(username) &&
                            resultSet.getString(MenuController.inEmployeeMenu ? "employee_password" : "renter_password").equals(password)) {
                        return true;
                    }
                }

            }catch (SQLException e){
            System.out.println("SCLEXEPTION" + e);
        }
        return false;
    }
}
