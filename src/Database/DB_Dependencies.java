package Database;

public class DB_Dependencies {

public final String DATABASE_URL = "jdbc:mysql://localhost:3306/sommerbo";
public final String USERNAME = "root";
public final String PASSWORD = "Kww1jll###";



public final String[] EMPLOYEE_INSERT_COLUMNS = {"employee_name", "employee_phone",
        "employee_username", "employee_password"};

public final String[] HOUSE_INSERT_COLUMNS = {"house_address", "house_zip_code", "house_city", "house_capacity",
        "house_size", "house_isRented"};

public final String[] RENTER_INSERT_COLUMNS = {"renter_name", "renter_phone", "renter_email", "renter_username",
        "renter_password", "house_id"};

public final String[] RENTAL_INSERT_COLUMNS = {"rental_start_date", "rental_end_date", "rental_price", "rental_depositum",
        "house_id", "renter_id", "employee_id"};

}
