package io.github.phonebook.DataBase;

import io.github.phonebook.MenuItemExecutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreateMenuDB implements MenuItemExecutor {
    @Override
    public void execute() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ФИО");
        String contactFIO = scanner.nextLine();
        System.out.println("Введите дату рождения YYYY-MM-DD");
        String contactDATE = scanner.nextLine();
        System.out.println("Введите количество проектов");
        String contactCoP = scanner.nextLine();
        System.out.println("Введите рейтинг");
        String contactRating = scanner.nextLine();
        System.out.println("Введите комментарий");
        String contactComment = scanner.nextLine();






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
            System.out.println("Creating in given database...");
            stmt = conn.createStatement();
            String sql =  "INSERT INTO Contacts VALUES('"+contactFIO+"', '"+contactDATE+"', "+contactCoP+", "+contactRating+",'"+contactComment+"')";
            stmt.executeUpdate(sql);
            System.out.println("Created in given database...");

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
