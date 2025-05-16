package Student_Management_System;

import java.sql.*;

public class StudentDAO {
    public static final String url="jdbc:postgresql://localhost:5432/DemoDataBase";
    public static final String username="postgres";
    public static final String password="K@rthik";

    static{
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,username,password);
    }

    public static void viewAllStudents(){
        String sql="SELECT roll_no,name,department,email_id FROM students";
        try(Connection con=getConnection(); Statement statement=con.createStatement(); ResultSet resultSet=statement.executeQuery(sql)){
            while (resultSet.next()){
                System.out.printf("Roll Number: %d, Name: %s, Department: %s, EMail ID: %s%n",
                        resultSet.getInt("roll_no"),
                        resultSet.getString("name"),
                        resultSet.getString("department"),
                        resultSet.getString("email_id"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addStudent(Students students){
        String sql="INSERT INTO students (roll_no,name,department,email_id) VALUES ( ?, ?, ?, ?)";
        try(Connection connection=getConnection();PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            preparedStatement.setInt(1,students.getRollNo());
            preparedStatement.setString(2,students.getName());
            preparedStatement.setString(3,students.getDepartment());
            preparedStatement.setString(4,students.getEmailId());
            preparedStatement.executeUpdate();
            System.out.println("✅ Student added successfully.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void deleteStudent(int id){
        String sql="DELETE FROM students WHERE roll_no=?";
        try(Connection connection=getConnection();PreparedStatement statement=connection.prepareStatement(sql)){
            statement.setInt(1,id);
            statement.executeUpdate();
            System.out.println("✅ Student deleted successfully.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void getUpdateStudent(Students students){
        String sql="UPDATE students SET name=?,department=?,email_id=? WHERE roll_no=?";
        try(Connection connection=getConnection();PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            preparedStatement.setString(1,students.getName());
            preparedStatement.setString(2,students.getDepartment());
            preparedStatement.setString(3,students.getEmailId());
            preparedStatement.setInt(4,students.getRollNo());
            preparedStatement.executeUpdate();
            System.out.println("✅ Student update successfully.");


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void searchByRollNO(Students students){
        String sql="SELECT name,department,email_id FROM students WHERE roll_no=?";
        try(Connection connection=getConnection();PreparedStatement preparedStatement= connection.prepareStatement(sql)){
            preparedStatement.setInt(1,students.getRollNo());
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                String name=resultSet.getString("name");
                String department=resultSet.getString("department");
                String emailId=resultSet.getString("email_id");

                System.out.println("Student Name: "+name);
                System.out.println("Department: "+department);
                System.out.println("Student EmailID: "+emailId);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void searchByDepartment(String department) {
        String sql="SELECT roll_no,name,department,email_id FROM students WHERE department=?";
        try(Connection connection=getConnection();PreparedStatement preparedStatement=connection.prepareStatement(sql)){
            preparedStatement.setString(1,department);
            ResultSet rs=preparedStatement.executeQuery();
            while (rs.next()) {
                System.out.println("Roll No: " + rs.getInt("roll_no"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Department: " + rs.getString("department"));
                System.out.println("Email ID: " + rs.getString("email_id"));
                System.out.println("---------------------------------");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
