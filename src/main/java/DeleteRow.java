import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static java.util.jar.Pack200.Packer.PASS;
import static org.postgresql.jdbc2.EscapedFunctions.USER;

public class DeleteRow {

    static void deleteCustomersWhereCustomeridIs2() {

        Connection conn;
        Statement stmt;

        try {
            //STEP 2: Register JDBC driver
            Class.forName("org.postgresql.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DBCONNECT.CustomersRecords.DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("The row is successfully deleted,please check the customers records for changes");
            stmt = conn.createStatement();

            String sql = "DELETE FROM customers  WHERE customerid=2";
            ResultSet rs = stmt.executeQuery(sql);

            rs.close();
        } catch (Exception se) {

            System.out.println("------------------------------------------------------------------------------------------------------------");
        }
    }
}
