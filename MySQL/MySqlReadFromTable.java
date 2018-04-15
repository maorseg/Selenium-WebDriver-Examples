package MySQL;

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

public class MySqlReadFromTable {

    private static String userName;
    private static String password;
    private static String dbURL;
    private static Connection dbconnection;

    @BeforeTest
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
    // Select * query to get all data from MySql table
    public static void ReadAllFromTable() {
        try {
            dbconnection = DriverManager.getConnection(dbURL, userName, password);
            Statement st = dbconnection.createStatement();

            // user is the table name
            String sqlStr = "select * from user;";
            ResultSet rs = st.executeQuery(sqlStr);
            System.out.println(String.format("Table contains below data:"));
            // Print the result untill all the records are printed
            // res.next() returns true if there is any next record else returns false

            while (rs.next()) {
                System.out.println(String.format("%s , %s , %s , %s ",
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4)));
            }

        }

        catch (SQLException e) {
        System.out.println("Connection to MySQL database failed");
        e.printStackTrace();

        }
    }

         @AfterTest
         public void tearDown () throws Exception {
                // Close database connection.
                if (dbconnection != null) {
                    dbconnection.close();
                }
            }
        }