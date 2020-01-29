<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>clients Store Application</title>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
    <center>
        <h1>clients-Gestion</h1>
        <h2>
            <a href="list">Liste des clients</a> 
        </h2>
    </center>
    <div align="center">
        <c:if test="${client != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${client == null}">
            <form action="insert" method="POST">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${client != null}">
                        Modifier client
                    </c:if>
                    <c:if test="${client == null}">
                        Ajouter client
                    </c:if>
                </h2>
            </caption>
                <c:if test="${client != null}">
                    <input type="hidden" name="login" value="<c:out value='${client.login}' />" />
                </c:if>           
            <tr>
                <th>Nom : </th>
                <td>
                    <input type="text" name="nom" size="45"
                            value="<c:out value='${client.last_name}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Prenom : </th>
                <td>
                    <input type="text" name="prenom" size="45"
                            value="<c:out value='${client.first_name}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Profession : </th>
                <td>
                    <input type="text" name="job_title" size="45"
                            value="<c:out value='${client.job_title}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Username : </th>
                <td>
                    <input type="text" name="login" size="45"
                            value="<c:out value='${client.login}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Password : </th>
                <td>
                    <input type="password" name="password" size="45"
                            value="<c:out value='${client.password}' />"
                    />
                </td>
            </tr>
          
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>