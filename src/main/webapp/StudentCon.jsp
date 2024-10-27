<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Confirm Registration</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-md-6">

                <div class="card shadow-sm">
                    <div class="card-header bg-success text-white text-center">
                        <h2>Registration Success!</h2>
                    </div>
                    <div class="card-body">

                        <p class="lead">Name: 
                            <strong><%= request.getAttribute("firstName") %> <%= request.getAttribute("lastName") %></strong>
                        </p>
                        

                        <p class="lead">Email: 
                            <strong><%= request.getAttribute("email") %></strong>
                        </p>
                    </div>

                    <div class="card-footer text-center">
                        <a href="index.html" class="btn btn-primary">Go to Home</a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap JS, Popper.js, and jQuery -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    
</body>
</html>
