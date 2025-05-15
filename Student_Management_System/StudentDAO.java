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
            System.out.printf("✅ Student added successfully.");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
