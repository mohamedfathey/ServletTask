

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add New Student</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>


<body>


    <div class="container mt-5">
    
	    <div class="row justify-content-center">
		      <% if (request.getAttribute("errorMessage") != null) { %>
		    <p style="color:red;"><%= request.getAttribute("errorMessage") %></p>
		<% } %>
		
		</div>
  

        <div class="row justify-content-center">
            <div class="col-md-8">
                <h2 class="text-center mb-4">Add New Student</h2>

                <form action="StudentCotroller" method="post" class="p-4 border rounded shadow-sm bg-light">
                    

                    <div class="form-group">
                        <label for="firstName">First Name:</label>
                        <input type="text" id="firstName" name="firstName" class="form-control" placeholder="Enter first name" required>
                    </div>


                    <div class="form-group">
                        <label for="lastName">Last Name:</label>
                        <input type="text" id="lastName" name="lastName" class="form-control" placeholder="Enter last name" required>
                    </div>


                    <div class="form-group">
                        <label for="email">Email:</label>
                        <input type="email" id="email" name="email" class="form-control" placeholder="Enter email" required>
                    </div>



                    <div class="text-center">
                        <button type="submit" class="btn btn-primary btn-block">Add Student</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
