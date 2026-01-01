package servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.StudentDAO;
import model.Student;

@WebServlet("/show_all")
public class ShowAllStudentsServlet extends HttpServlet {
    private StudentDAO studentDAO;

    public void init() {
        studentDAO = new StudentDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Student> listStudents = studentDAO.getAllStudents();
        request.setAttribute("listStudents", listStudents);
        request.getRequestDispatcher("students.jsp").forward(request, response);
    }
}