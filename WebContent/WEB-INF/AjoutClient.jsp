<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>clients Store Application</title>
</head>
<body>
    <center>
        <h1>clients-Gestion</h1>
        <h2>
            <a href="/new">Add New client</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">Liste des clients</a>
             
        </h2>
    </center>
    <div align="center">
        <c:if test="${client != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${client == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${client != null}">
                        Edit client
                    </c:if>
                    <c:if test="${client == null}">
                        Add New client
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
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>   
</body>
</html>