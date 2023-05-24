package Utils;

import org.apache.poi.ss.formula.functions.Now;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBUtility {

    static Connection conn=null;
    static Statement statement=null;
    private static ResultSet rset;
    private static ResultSetMetaData rsetMetaData;

    //this method wiol create the connection to the DB, will execute query and return
    //object for resultSet
    public static ResultSet getResultSet(String sqlQuery){
        try {
            conn= DriverManager.getConnection(ConfigReader.getPropertyValue("urldb"),
                    ConfigReader.getPropertyValue("usernamedb"),
                    ConfigReader.getPropertyValue("passworddb"));

            statement= conn.createStatement();
            rset=statement.executeQuery(sqlQuery);

        } catch (SQLException e) {
            e.printStackTrace();
        }
return rset;
    }

   public static ResultSetMetaData getrSetMetaDa(String query){
rset=getResultSet(query);
rsetMetaData=null;
//we use this line to get the data in tabular format
       try {
           rsetMetaData=rset.getMetaData();

       } catch (SQLException e) {
           e.printStackTrace();
       }
return rsetMetaData;
   }

   //this method is extracting the data which will be stored in list of maps
   public static List<Map<String,String>> getListOfMapsFromRset(String query){
        rsetMetaData=getrSetMetaDa(query);
       List<Map<String,String>> listFromRset = new ArrayList<>();

     try {
         while (rset.next()) {
             Map<String,String> map=new LinkedHashMap<>();
             for (int i = 1; i <= rsetMetaData.getColumnCount(); i++) {
                 String key=rsetMetaData.getColumnName(i);
                 String value=rset.getString(key);
                 map.put(key, value);
             }
listFromRset.add(map);
         }
     }catch(SQLException e){
         e.printStackTrace();

       }finally {
         DBUtility.closeResultSet(rset);
         DBUtility.closeStatement(statement);
         DBUtility.closeConnection(conn);
     }
        return listFromRset;
     }
     //order to make connection
    // connection is made
    //statement is made
    //we get resultset

    //now we need to close them in reverse order

    //close result set
    //close statement
    //close connection

    public static void closeResultSet(ResultSet rset){
        if(rset!=null){
            try {
                rset.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

   }

public static void closeStatement(Statement statement) {
    if (statement != null) {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

public static void closeConnection(Connection conn) {
    if (conn != null) {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

    public static List<Map<String, String>> getListOfMapsFromRset2(String query) {
        rsetMetaData = getrSetMetaDa(query);
        List<Map<String, String>> listFromRset = new ArrayList<>();
        try {
            while (rset.next()) {
                Map<String, String> map = new LinkedHashMap<>();
                for (int i = 1; i <= rsetMetaData.getColumnCount(); i++) {
                    //fetching key and value from the columns
                    String key = rsetMetaData.getColumnName(i);
                    String value = rset.getString(key);
                    map.put(key, value);
                }
                System.out.println(map);
                listFromRset.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtility.closeResultSet(rset);
            DBUtility.closeStatement(statement);
            DBUtility.closeConnection(conn);
        }
        return listFromRset;
    }

}
