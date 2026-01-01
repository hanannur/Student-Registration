<%@ page import="java.util.List" %>
<%@ page import="model.Student" %>


<html>
<body>
<h2>Registered Students</h2>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Year</th>
    </tr>
    <%
        List<Student> listStudents = (List<Student>) request.getAttribute("listStudents");
        if (listStudents != null) {
            for (Student s : listStudents) {
    %>
    <tr>
        <td><%= s.getName() %></td>
        <td><%= s.getEmail() %></td>
        <td><%= s.getYear() %></td>
    </tr>
    <%
            }
        }
    %>
</table>
<br>
<a href="index.jsp">Register New Student</a>
</body>
</html>