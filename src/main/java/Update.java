import java.sql.*;

import static java.util.jar.Pack200.Packer.PASS;
import static org.postgresql.jdbc2.EscapedFunctions.USER;

public class Update{





    static void updateCustomersRecords() {

        Connection conn = null;
        Statement stmt = null;

        try {
            //STEP 2: Register JDBC driver
            Class.forName("org.postgresql.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DBCONNECT.CustomersRecords.DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("The table is successfully updated:please check the customers records for the updates");
            stmt = conn.createStatement();

            String sql = "UPDATE customers SET firstname='Lerato',lastname='Mabitso' WHERE customerid=1";
            ResultSet rs1 = stmt.executeQuery(sql);


            rs1.close();
        } catch (Exception se) {

            System.out.println("------------------------------------------------------------------------------------------------------------");
        }
    }
}
