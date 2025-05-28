import java.io.BufferedReader;
import java.nio.Buffer;
import java.sql.DriverManager;
import java.sql.*;
import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library","root","sundari@2005");
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("--------------------Welcome To The Library--------------------");
            System.out.println("Choose What You Wanted To Do : \n1.View Books \n2.Update Books\n3.Insert Books\n4.Delete Books");
            int choice = Integer.parseInt(bf.readLine());
            PreparedStatement psmt;
            ResultSet rs;
            if(choice == 1){
                System.out.println("You wanted to View all Books");
                psmt=con.prepareStatement("SELECT * fROM books ");
                rs = psmt.executeQuery();
                System.out.println("------------------------------------------------");
                while(rs.next()){
                    int id = rs.getInt("id");
                    String title = rs.getString("title");
                    String author = rs.getString("author");
                    System.out.println("ID: " + id + " | Title: " + title + " | Author: " + author);
                }
                System.out.println("------------------------------------------------");
            }
            else if (choice == 2){
                System.out.println("You Wanted to Update Books");
                System.out.println("Enter The Book Id to Update: ");
                int id = Integer.parseInt(bf.readLine());
                System.out.print("Enter New Title: ");
                String title = bf.readLine();
                System.out.print("Enter New Author: ");
                String author = bf.readLine();
                String qry = "Update books set title=?,author=? where id=?";
                psmt = con.prepareStatement(qry);
                psmt.setString(1, title);
                psmt.setString(2, author);
                psmt.setInt(3, id);
                int rows = psmt.executeUpdate();
                if (rows > 0) {
                    System.out.println("Updated Successfully.");
                } else {
                    System.out.println("Book ID not found.");
                }
            }
            else if(choice == 3){
                System.out.println("You Wanted to Insert Books");
                System.out.print("Enter Book ID: ");
                int id = Integer.parseInt(bf.readLine());
                System.out.print("Enter Book Title: ");
                String title = bf.readLine();
                System.out.print("Enter Book Author: ");
                String author = bf.readLine();
                String qry = "INSERT INTO books(id,title,author) VALUES(?,?,?)";
                psmt = con.prepareStatement(qry);
                psmt.setInt(1,id);
                psmt.setString(2,title);
                psmt.setString(3,author);
                int rows = psmt.executeUpdate();
                if(rows > 0){
                    System.out.println("Book inserted successfully!");
                } else {
                    System.out.println("Failed to insert book.");
                }
            } else if(choice == 4) {
                System.out.println("You Wanted to Delete Books");
                System.out.println("Enter the Book Id:");
                int id = Integer.parseInt(bf.readLine());
                String qry = ("DELETE FROM books WHERE id=?");
                psmt = con.prepareStatement(qry);
                psmt.setInt(1, id);
                int rows = psmt.executeUpdate();
                if (rows > 0) {
                    System.out.println("Book deleted successfully.");
                } else {
                    System.out.println("Book ID not found.");
                }
            }
            else{
                System.out.println("You Entered Wrong Choice");
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}