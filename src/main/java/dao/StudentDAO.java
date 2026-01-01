package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Student;
import util.DBConnection;

public class StudentDAO {
    private static final String INSERT_STUDENT_SQL = "INSERT INTO students (name, email, year) VALUES (?, ?, ?)";
    private static final String SELECT_ALL_STUDENTS = "SELECT * FROM students";

    public void registerStudent(Student student) throws SQLException {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setString(2, student.getEmail());
            preparedStatement.setInt(3, student.getYear());
            preparedStatement.executeUpdate();
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_STUDENTS)) {
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                int year = rs.getInt("year");
                students.add(new Student(id, name, email, year));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}