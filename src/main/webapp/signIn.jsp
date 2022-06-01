<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Book Collection</title>
        <link rel="stylesheet" href="css/yellow.css">
    </head>
    <body class="text-center">
        <main class="form-signin w-100 m-auto">
            <div class="topnav">
                <a class="active" href="index.jsp">Home</a>
                <a href="#genres">Genres</a>
                <a href="#myprofile">My profile</a>
                <input type="text" placeholder="Search..">
              </div>
        <form action="/yellow/signIn" method="post">
        <figure>
            <img src="img/BookCollection.jpg" alt="Logo" width="200" height="120">
        </figure>
        <h1>Please sign in</h1>
        <div class="form-floating">
            <input name="firstname" class="form-control" id="floatingNome" placeholder="Mario" required>
            </div>
            <div class="form-floating">
                <input name="lastname" class="form-control" id="floatingCognome" placeholder="Rossi" required>
                </div>
        <div class="form-floating">
        <input name="email" class="form-control" id="floatingInput" placeholder="name@example.com" required>
        </div>
        <div class="form-floating">
        <input name="password" type="password" class="form-control" id="floatingPassword" placeholder="password" required>
        </div>
        <div class="form-floating">
            <input name="username" class="form-control" id="floatingUsername" placeholder="Username" required>
            </div>
          <div class="checkbox mb-3">
            <label><input type="checkbox" value="remember-me">Remember me</label>
          </div>
          <button class="w-100 btn btn-lg btn-primary" type="submit">Sign in</button>
    </form>
        </main>
    </body>
</html>