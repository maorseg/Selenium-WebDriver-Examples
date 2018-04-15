package MySQL;

/**
 * Created by Maor on 4/15/2018.
 */

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.sql.*;

/**
 * Created by Maor on 4/14/2018.
 * 1. Download and install https://dev.mysql.com/downloads/installer/ --> Windows (x86, 32-bit), MSI Installer
 * 2. Open MySQL command line client from Start menu
 (default userName = "root"; password = "root";
 * 3. To view available databases In mysql -> "show databases;"
 * 4. Create DB -> "CREATE DATABASE test";
 * 5. To use test DB -> "use test"
 * 5. To show all tables in the DB -> "show tables;"
 * 6. To insert values to the DB -> "INSERT INTO user (id, name, city, age) VALUES (?, '?', '?', ?)";
 * 7. Select all values from the tacle -> "select * from user;"
 */

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.sql.*;

public class MySqlActionsOnTable {

    private static String userName;
    private static String password;
    private static String dbURL;
    private static Connection dbconnection;

    @BeforeTest
    // Create Connection between Java to the DB
    public void setUp() {

        try {
            userName = "root";
            password = "root";

            // test is the DB name
            dbURL = "jdbc:mysql://127.0.0.1:3307/test";
            Class.forName("com.mysql.jdbc.Driver");
        }

        catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found.");
            e.printStackTrace();
        }
    }

    @Test
    // Execute SQL Query - e.g. Select * to get all data from MySql table
    public static void ReadFromTable() {
        try {
            dbconnection = DriverManager.getConnection(dbURL, userName, password);
            Statement stmt  = dbconnection.createStatement();

            // user is the table name
            String sqlStr = "select * from user;";
            ResultSet resultSet  = stmt.executeQuery(sqlStr);
            System.out.println(String.format("Table contains below data:"));
            // Print the result untill all the records are printed
            // res.next() returns true if there is any next record else returns false

            while (resultSet .next()) {
                System.out.println(String.format("%s , %s , %s , %s ", resultSet .getString(1), resultSet .getString(2), resultSet .getString(3), resultSet .getString(4)));
            }

        }

        catch (SQLException e) {
            System.out.println("Connection to MySQL database failed");
            e.printStackTrace();

        }
    }

    @Test
    // Execute SQL Query - e.g. insert new data values to MySql table
    public static void WriteToTable() {
        try {
            // Create a mysql Database connection
            String myUrl = "jdbc:mysql://localhost:3307/test";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");

            // The mysql insert statement
            String query = " Insert into user (id, name , city, age) values(?,?,?,?)";

            // Create the mysql insert prepared statement
            PreparedStatement preparedStmt = conn.prepareStatement(query);

            // 1/2/3/4 i.e column number and than the value to insert
            preparedStmt.setString(1, "9");
            preparedStmt.setString(2, "Shalomi");
            preparedStmt.setString(3, "Tel Aviv");
            preparedStmt.setString(4, "37");

            // Execute the query
            preparedStmt.execute();
            conn.close();

        } catch (Exception e) {
            System.out.println("Got an exception!");
            System.out.println(e.getMessage());
        }
    }

    @Test
    // Execute SQL Query - e.g. update  data values in MySql table
    public static void UpdateValueInTable() {
        try {
            // Create a mysql Database connection
            String myUrl = "jdbc:mysql://localhost:3307/test";
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(myUrl, "root", "root");

            // The mysql update statement
            String query = "update user set name = 'Frank', city = 'Paris', age = '68' where id = '1'";

            // Create the mysql update prepared statement
            PreparedStatement preparedStmt = conn.prepareStatement(query);

            // Execute the query
            preparedStmt.execute();
            conn.close();

        } catch (Exception e) {
            System.out.println("Got an exception!");
            System.out.println(e.getMessage());
        }

    }

    @AfterTest
    public void tearDown () throws Exception {
        // Close database connection to free used memory
        if (dbconnection != null) {
            dbconnection.close();
        }
    }
}
