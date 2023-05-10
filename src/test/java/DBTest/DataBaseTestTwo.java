package DBTest;

import jdk.jfr.MetadataDefinition;

import java.sql.*;

public class DataBaseTestTwo {
    public static void main(String[] args) {
        //to build the connection with the database, we need 3 things
        //URL-address, username, password
        String url="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username="syntax_hrm";
        String password="syntaxhrm123";

        try {
            Connection conn= DriverManager.getConnection(url, username, password);
            System.out.println("Connection is created for Batch15");
            //create a statement to send SQL queries
            Statement statement= conn.createStatement();
//when we send any query to the database, then DB returns
            //result set (Tables with rows and columns)
            //ResultSet rset=statement.executeQuery("select FirstName, LastName from person");
            ResultSet rset= statement.executeQuery("select firstname, lastname, age, city " +
                    "from person where city is not null;");

            ResultSetMetaData metaData=rset.getMetaData();
      //print all the columns/header values
            for(int i=1; i<= metaData.getColumnCount(); i++){
              String columnName=metaData.getColumnName(i);
                System.out.println(columnName);
            }

           // we want to loop through every column and every row this time

            while(rset.next()){
                for(int i=1; i<= metaData.getColumnCount();i++){
                 String value=rset.getString(metaData.getColumnName(i));
                    System.out.print(value+" ");

                }
                System.out.println();
                //just to add a space in between words

            }

           //while(rset.next()){
               //String fName= rset.getString("FirstName");
              // String lName= rset.getString("LastName");
              // System.out.println(fName+" "+lName);

          // }
           //result set metadata- Object that contains information about the result
           //information such as in teh table how many colums, rows, names of the columns,
            //and number of rows



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
