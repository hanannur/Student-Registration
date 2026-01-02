<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Registered Students</title>
    <style>
        table { width: 50%; border-collapse: collapse; margin: 20px 0; }
        th, td { padding: 10px; text-align: left; border-bottom: 1px solid #ddd; }
        th { background-color: #f2f2f2; }
        /* Added border style here so we don't need border="1" in HTML */
        table, th, td { border: 1px solid black; }
    </style>
</head>
<body>
<h2>Registered Students</h2>

<!-- I removed the comment that was causing the crash -->
<table>
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Year</th>
    </tr>

    <!-- The c:forEach loop iterates over the list sent from the Servlet -->
    <c:forEach var="student" items="${listStudents}">
        <tr>
            <td>${student.name}</td>
            <td>${student.email}</td>
            <td>${student.year}</td>
        </tr>
    </c:forEach>
</table>

<!-- Show a message if list is empty -->
<c:if test="${empty listStudents}">
    <p>No students registered yet.</p>
</c:if>

<br>
<a href="index.jsp">Register New Student</a>
</body>
</html>