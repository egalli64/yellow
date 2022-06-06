<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/index.css">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Book Collection</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
	<section class="h-100 gradient-form" style="background-color: #eee;">
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-xl-10">
					<div class="card rounded-3 text-black">
						<div class="row g-0">
							<div class="col-lg-6">
								<div class="card-body p-md-5 mx-md-4">

									<div class="text-center">
										<img src="img/BookCollection2.jpg" style="width: 185px;"
											alt="logo">
									</div>

									<form action="/yellow/login" method="post">
										<p>Please login</p>

										<div class="form-outline mb-4">
											<input name="username" id="form2Example11"
												class="form-control" placeholder="Username" />
										</div>

										<div class="form-outline mb-4">
											<input type="password" name="password" id="form2Example22"
												class="form-control" placeholder="Password" />
										</div>

										<div class="text-center pt-1 mb-5 pb-1">
											<button
												class="btn btn-primary btn-block fa-lg gradient-custom-2 mb-3">
												Log in</button>
											<a class="text-muted" href="#!">Forgot password?</a>
										</div>
									</form>
									<div
										class="d-flex align-items-center justify-content-center pb-4">
										<p class="mb-0 me-2">Don't have an account?</p>
										<a href="signIn.jsp">
											<button type="button" class="btn btn-outline-danger">Create
												new</button>
										</a>
									</div>

								</div>
							</div>
							<div class="col-lg-6 d-flex align-items-center gradient-custom-2">
								<div class="text-white px-3 py-4 p-md-5 mx-md-4">
									<h4 class="mb-4">Best bookshelf online</h4>
									<p class="small mb-0">this is your Book Collection</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>