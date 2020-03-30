import java.sql.*;

import static java.util.jar.Pack200.Packer.PASS;
import static org.postgresql.jdbc2.EscapedFunctions.USER;

public class SelectName{


    static void selectNameFromCustomersWhereCustomeridIs1(){


        Connection conn = null;
        Statement stmt = null;

        try{
            //STEP 2: Register JDBC driver
            Class.forName("org.postgresql.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DBCONNECT.CustomersRecords.DB_URL, USER, PASS);
            System.out.println("Connected database successfully...");

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            stmt = conn.createStatement();

            String sql = "SELECT firstname from customers WHERE customerid=1";



            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                String first = rs.getString("firstname");

                //Display values
                System.out.println("FirstName: " + first);
            }
            rs.close();
        } catch(Exception se){
            //Handle errors for JDBC
            se.printStackTrace();
        }//Handle errors for Class.forName
        finally{
            //finally block used to close resources
            try{
                if(stmt!=null)
                    conn.close();
            }catch(SQLException ignored){
            }// do nothing
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("------------------------------------------------------------------------------------------------------------");

    }
}
