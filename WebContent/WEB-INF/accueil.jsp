<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
</head>
<body>
<h1>Bienvenue dans la page d'accueil</h1>

<c:choose>
	<c:when test="${sessionScope.admin != null}">
		<a href="clients/list">Affichage de la liste des clients</a>
		<a href="clients/new">Ajout d'un client</a>
		<a href="logout">Se deconnecter</a>
	</c:when>
	<c:otherwise>
		<form  method="POST">
		 <fieldset>
		  <legend>Connexion:</legend>
		  <table>
		  	<tr>
		  		<td>Login</td>
		  		<td><input name="login" type="text" /></td>
		  	</tr>
		  	<tr>
		  		<td>Password</td>
		  		<td><input name="password" type="password"/></td>
		  	</tr>
		  </table>
		  <input type="submit" name="connecter" value="login">
		 </fieldset>
		</form>
	</c:otherwise>
</c:choose>
</body>
</html>