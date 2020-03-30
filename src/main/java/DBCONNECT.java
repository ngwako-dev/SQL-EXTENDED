import java.sql.*;



public class DBCONNECT {

    public static void main(String[] args) {




          CustomersRecords.printCustomersRecords();


          SelectAllName.selectNames();


          SelectName.selectNameFromCustomersWhereCustomeridIs1();

          Update.updateCustomersRecords();

          DeleteRow.deleteCustomersWhereCustomeridIs2();

        SelectDistinct.selectDistinctStatus();

        SelectMaximumAmount.selectMaximumAmount();


    }//end main



    public static class CustomersRecords{
//         database URL
         static final String DB_URL = "jdbc:postgresql:umuzi";

//           Database credentials
           static final String USER = "user";
           static final String PASS = "pass";


          static void printCustomersRecords(){

              Connection conn = null;
              Statement stmt = null;

              try{
                  //STEP 2: Register JDBC driver
                  Class.forName("org.postgresql.Driver");

                  //STEP 3: Open a connection
                  System.out.println("Connecting to a selected database...");
                  conn = DriverManager.getConnection(CustomersRecords.DB_URL, USER, PASS);
                  System.out.println("Connected database successfully...");

                  //STEP 4: Execute a query
                  System.out.println("Creating statement...");
                  stmt = conn.createStatement();

                  String sql = "SELECT * FROM customers";
                  ResultSet rs = stmt.executeQuery(sql);


                  //STEP 5: Extract data from result set
                  while(rs.next()){
                      //Retrieve by column name
                        int id  = rs.getInt("customerid");

                        String first = rs.getString("firstname");
                        String last = rs.getString("lastname");
                        String gend=rs.getString("gender");
                        String addrss=rs.getString("address");
                        String em=rs.getString("email");
                        String cit=rs.getString("city");
                        String countr=rs.getString("country");

                      //Display values

                         System.out.print("CustomerID: " + id);
                         System.out.print(", FirstName: " + first);
                         System.out.print(", LastName: " + last);
                         System.out.print(", Gender: " +gend);
                         System.out.print(", Address: " +addrss);
                         System.out.print(", Email: " +em);
                         System.out.print(", City: " +cit);
                         System.out.println(", Country: "+countr);
                         System.out.println(" ");

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

}


