package io.github.phonebook.DataBase;

import io.github.phonebook.MenuItemExecutor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateDB implements MenuItemExecutor {

    String contactFIO;
    String contactDATE;
    String contactCoP;
    String contactRating;
    String contactComment;

    public void inputContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите ФИО для изменения");
        contactFIO = scanner.nextLine();
        System.out.println("Введите НОВУЮ дату рождения YYYY-MM-DD");
        contactDATE = scanner.nextLine();
        System.out.println("Введите НОВОЕ количество проектов");
        contactCoP = scanner.nextLine();
        System.out.println("Введите НОВЫЙ рейтинг");
        contactRating = scanner.nextLine();
        System.out.println("Введите НОВЫЙ комментарий");
        contactComment = scanner.nextLine();
    }

    @Override
    public void execute() {
            inputContact();

        Connection conn = null;
        Statement stmt = null;
        try {
            conn = ConnectionPool.INSTANCE.getConn();


            //STEP 3: Execute a query
            System.out.println("Creating in given database...");
            stmt = conn.createStatement();
            //'"+contactComment+"'
            String sql = "UPDATE Contacts SET DATE ='" + contactDATE + "', COUNTOFPROJECTS='" + contactCoP + "', " +
                    "RATING='" + contactRating + "', COMMENTS='" + contactComment + "'    WHERE name ='" + contactFIO + "'";
            stmt.executeUpdate(sql);
            System.out.println("Created in given database...");

            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } //end finally try
        } //end try
        System.out.println("Goodbye!");

    }
}
