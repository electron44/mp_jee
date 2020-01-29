<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Client crud</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
    <center>
        <h1>Clientéle gestion</h1>
        <h2>
            <a href="new">Ajouter un nouveau client</a>
             
        </h2>
    </center>
    <div align="center">
        <table class="table table-bordered" cellpadding="5">
            <caption><h2>List des Clients</h2></caption>
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
                        <a class="btn btn-success" href="edit?login=<c:out value='${Client.login}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a class="btn btn-danger" href="delete?login=<c:out value='${Client.login}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>