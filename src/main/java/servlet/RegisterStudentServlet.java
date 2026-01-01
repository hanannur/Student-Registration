package servlet;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.StudentDAO;
import model.Student;

@WebServlet("/register")
public class RegisterStudentServlet extends HttpServlet {
    private StudentDAO studentDAO;

    public void init() {
        studentDAO = new StudentDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        int year = Integer.parseInt(request.getParameter("year"));

        Student newStudent = new Student(name, email, year);
        try {
            studentDAO.registerStudent(newStudent);
            response.sendRedirect("show_all");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("index.jsp?error=exists");
        }
    }
}