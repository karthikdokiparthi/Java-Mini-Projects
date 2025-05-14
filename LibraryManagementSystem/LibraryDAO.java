package LibraryManagementSystem;

import java.sql.*;
import java.time.LocalDate;

public class LibraryDAO {

    public static final String url="jdbc:postgresql://localhost:5432/LibraryManagement";
    public static final String user="postgres";
    public static final String password="K@rthik";

    static {
        try {
            Class.forName("org.postgresql.Driver"); // Load MySQL driver
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException{
        return DriverManager.getConnection(url,user,password);
    }

    public static void insertBooks(Book book){
        String sql = "INSERT INTO books (book_id, title, author, publisher, year, genre, quantity) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, book.getBookId());
            stmt.setString(2, book.getTitle());
            stmt.setString(3, book.getAuthor());
            stmt.setString(4, book.getPublisher());
            stmt.setInt(5, book.getYear());
            stmt.setString(6, book.getGenre());
            stmt.setInt(7, book.getQuantity());
            stmt.executeUpdate();
            System.out.println("Book inserted successfully into DB!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void viewBooks() {
        String sql="SELECT * FROM books";
        try(Connection con=getConnection();Statement statement=con.createStatement();ResultSet resultSet=statement.executeQuery(sql)){
            System.out.println("==== List of Books ====");
            while(resultSet.next()){
                System.out.printf("ID: %s, Title: %s, Author: %s, Publisher: %s, Year: %d, Genre: %s, Quantity: %d%n",
                        resultSet.getString("book_id"), resultSet.getString("title"), resultSet.getString("author"), resultSet.getString("publisher"),
                        resultSet.getInt("year"), resultSet.getString("genre"), resultSet.getInt("quantity"));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static void insertMembers(Member member) {
        String sql = "INSERT INTO members (member_id, name, phone_number) VALUES (?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement preparedStatement = con.prepareStatement(sql)) {

            preparedStatement.setInt(1, member.getId());
            preparedStatement.setString(2, member.getName());
            preparedStatement.setLong(3, member.getPhNo());

            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("New Member added successfully.");
            } else {
                System.out.println("Failed to add new member.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void viewMembers() {
        String sql="SELECT * FROM members";
        try(Connection con=getConnection();Statement statement=con.createStatement();ResultSet resultSet=statement.executeQuery(sql)){
            System.out.println("=== List of Members ===");
            while(resultSet.next()){
                System.out.printf("ID: %s, Name: %s,Phone Number: %d%n",
                        resultSet.getInt("member_id"), resultSet.getString("name"), resultSet.getLong("phone_number"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void createAdminAccount(AdminAccess adminAccess){
        String url="INSERT INTO admins (id,username,password) VALUES (?,?,?)";
        try(Connection con=getConnection();PreparedStatement preparedStatement=con.prepareStatement(url)){
            preparedStatement.setInt(1,adminAccess.getId());
            preparedStatement.setString(2,adminAccess.getUserName());
            preparedStatement.setString(3,adminAccess.getPassword());
            preparedStatement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static boolean getAdminAccess(AdminAccess adminAccess){
        String sql="SELECT * FROM admins WHERE username=? AND password=?";
        try(Connection con=getConnection();PreparedStatement preparedStatement=con.prepareStatement(sql)){
            preparedStatement.setString(1,adminAccess.getUserName());
            preparedStatement.setString(2,adminAccess.getPassword());
            ResultSet resultSet=preparedStatement.executeQuery();
            return resultSet.next();
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void getAllAdmins(){
        String sql="SELECT id,username FROM admins";
        try(Connection con=getConnection();Statement statement= con.createStatement();ResultSet resultSet=statement.executeQuery(sql)){
            System.out.println("===== Admin Details =====");
            while (resultSet.next()) {
                System.out.printf("ID: %d, UserName: %s%n",
                        resultSet.getInt("id"),
                        resultSet.getString("username"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static boolean setIssueBooks(Member member,Book book){
        String sqlMember="SELECT * FROM members WHERE member_id=?";
        String sqlBook="SELECT * FROM books WHERE book_id=?";
        String sqlInsertIssue="INSERT INTO issues (member_id,book_id,issue_date) VALUES (?,?,?)";
        String sqlUpdateBooks="UPDATE books SET quantity=quantity-1 WHERE book_id=?";

        try(Connection con=getConnection();
            PreparedStatement preparedMember=con.prepareStatement(sqlMember);
            PreparedStatement preparedBook=con.prepareStatement(sqlBook);
            PreparedStatement preparedIssueBook=con.prepareStatement(sqlInsertIssue);
            PreparedStatement preparedUpdateBooks=con.prepareStatement(sqlUpdateBooks)){

            preparedMember.setInt(1,member.getId());
            ResultSet rsMember=preparedMember.executeQuery();
           if(!rsMember.next()){
                return false;
           }

           preparedBook.setString(1,book.getBookId());
           ResultSet rsBook=preparedBook.executeQuery();
           if(!rsBook.next()){
               return false;
           }

           int quantity=rsBook.getInt("quantity");
           if(quantity <= 0){
               return false;
           }

           preparedIssueBook.setInt(1,member.getId());
           preparedIssueBook.setString(2,book.getBookId());
           preparedIssueBook.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
           preparedIssueBook.executeUpdate();

           preparedUpdateBooks.setString(1,book.getBookId());
           preparedUpdateBooks.executeUpdate();

           return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
