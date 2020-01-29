<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Accueil</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css">
</head>
<body>
<style>
	a{
		display :block;
	}
</style>
<h1 class="text-center">Bienvenue dans la page d'accueil</h1>

<c:choose>
	<c:when test="${sessionScope.admin != null}">
		<a href="clients/list">Affichage de la liste des clients</a>
		<a href="clients/new">Ajout d'un client</a>
		<a href="logout">Se deconnecter</a>
	</c:when>
	<c:otherwise>
		<div class="container">
    <div class="row">
      <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
        <div class="card card-signin my-5">
          <div class="card-body">
            <h5 class="card-title text-center">Se connecter</h5>
            <form  class="form-signin" method="POST">
              <div class="form-label-group">
                <label for="username">Username</label>
                <input type="text" id="username" class="form-control" placeholder="username" name="username" required autofocus>
              </div>
              <div class="form-label-group">
             	 <label for="inputPassword">Password</label>
                <input type="password" id="password" class="form-control" placeholder="Password" name="password" required>
              </div>
			<button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Sign in</button>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
	</c:otherwise>
</c:choose>
</body>
</html>