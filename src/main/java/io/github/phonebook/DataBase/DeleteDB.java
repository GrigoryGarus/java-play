package io.github.phonebook.DataBase;

import io.github.phonebook.MenuItemExecutor;

import java.sql.*;
import java.util.Scanner;

public class DeleteDB implements MenuItemExecutor {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя для удаления");
        String contact = scanner.nextLine();


        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 1: Register JDBC driver
            Class.forName("org.h2.Driver");

            //STEP 2: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection("jdbc:h2:tcp://localhost:9092/data",
                    "sa","");

            //STEP 3: Execute a query
            stmt = conn.createStatement();
            //''
            String sql =  "delete from Contacts where name='"+contact+"'";
             stmt.executeUpdate(sql);
            System.out.println("Контакт "+contact+" удален.");

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
