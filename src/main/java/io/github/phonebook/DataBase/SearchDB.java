package io.github.phonebook.DataBase;

import io.github.phonebook.MenuItemExecutor;

import java.sql.*;
import java.util.Scanner;

public class SearchDB implements MenuItemExecutor {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя для поиска");
        String contact = scanner.nextLine();


        Connection conn = null;
        Statement stmt = null;
        try {



            //STEP 3: Execute a query
            conn = ConnectionPool.INSTANCE.getConn();
            stmt = conn.createStatement();
            //''
            String sql =  "select * from Contacts where name like '%"+contact+"%'";
             ResultSet rs = stmt.executeQuery(sql);
             while ( rs.next()){
                 System.out.println(rs.getString("NAME"));
                 System.out.println(rs.getDate("DATE"));
                 System.out.println(rs.getInt("COUNTOFPROJECTS"));
                 System.out.println(rs.getFloat("RATING"));
                 System.out.println(rs.getString("COMMENTS"));
             }

            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch(SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch(Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try{
                if(stmt!=null) stmt.close();
            } catch(SQLException se2) {
            } // nothing we can do
            try {
                if(conn!=null) conn.close();
            } catch(SQLException se){
                se.printStackTrace();
            } //end finally try
        } //end try
        System.out.println("Goodbye!");

    }
}
