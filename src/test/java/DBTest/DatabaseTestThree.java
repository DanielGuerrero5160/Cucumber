package DBTest;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DatabaseTestThree {

    public static void main(String[] args) {
        //to build the connection with the database, we need 3 things
        //URL-address, username, password
        String url="jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username="syntax_hrm";
        String password="syntaxhrm123";

        try {
            Connection conn= DriverManager.getConnection(url, username, password);
            System.out.println("Connection is created for Batch15");
            Statement statement= conn.createStatement();
            String query= "select * from person;";
            ResultSet rset= statement.executeQuery(query);
            ResultSetMetaData metaData=rset.getMetaData();
            //extract data from resultset and store it in java dataStructure
            List<Map<String,String>> listFromRset = new ArrayList<>();
            //interate through all the rows
            while(rset.next()){
              Map<String,String> map=new LinkedHashMap<>();
                for (int i = 1; i <= metaData.getColumnCount(); i++) {
                String key=metaData.getColumnName(i);
                String value=rset.getString(key);
                map.put(key, value);


                }
                System.out.println(map);
                listFromRset.add(map);

            }






        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
