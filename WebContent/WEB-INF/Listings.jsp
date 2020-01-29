<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Clients Store Application</title>
</head>
<body>
    <center>
        <h1>Customers Management</h1>
        <h2>
            <a href="clients/new">Ajouter un nouveau client</a>
            &nbsp;&nbsp;&nbsp;
            <a href="clients/list">Lister les clients</a>
             
        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Clients</h2></caption>
            <tr>
                <th>Login</th>
                <th>Nom</th>
                <th>prenom</th>
                <th>profession</th>
                <th>Action</th>
            </tr>
            <c:forEach var="Client" items="${listClient}">
                <tr>
                    <td><c:out value="${Client.login}" /></td>
                    <td><c:out value="${Client.last_name}" /></td>
                    <td><c:out value="${Client.last_name}" /></td>
                    <td><c:out value="${Client.job_title}" /></td>
                    <td>
                        <a href="clients/edit?login=<c:out value='${Client.login}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="clients/delete?login=<c:out value='${Client.login}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>