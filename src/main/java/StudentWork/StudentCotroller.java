package StudentWork;

import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;



@WebServlet("/StudentCotroller")
public class StudentCotroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private StudentDb studentDb ;
	
	   
    @Resource(name="jdbc/web_student_tracker")
		private DataSource dataSource;
    @Override
   	public void init() throws ServletException {
   		super.init();
   		
   		try {
   			studentDb = new StudentDb(dataSource);
   		}
   		catch (Exception exc) {
   			throw new ServletException(exc);
   		}
   	}
    
  
    public StudentCotroller() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher =
				  request.getRequestDispatcher("/AddNewStudent1.jsp");
				  dispatcher.forward(request, response); 
				  
	
	}
	


	 public static boolean validateName(String name) {
	        String regex = "^[A-Za-z ]{8,30}$"; 
	        return name != null && name.matches(regex);
	    }

	 public static boolean validateEmail(String email) {
		    String regex = "^[A-Za-z0-9+_.-]+@ci\\.menofia\\.edu\\.eg$"; 
		    return email != null && email.matches(regex);
		}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    String firstName = request.getParameter("firstName");
	    String lastName = request.getParameter("lastName");
	    String email = request.getParameter("email");
	    
	    boolean isValid = true;
        StringBuilder errorMessage = new StringBuilder();

        if (!validateName(firstName)) {
            isValid = false;
            errorMessage.append("Plase Enter Your FirstName ");
        }
        if (!validateName(lastName)) {
            isValid = false;
            errorMessage.append("Plase Enter Your LastName ");
        }
        if (!validateEmail(email)) {
            isValid = false;
            errorMessage.append("Plase Enter Your Correct Email");
        }
        
        if (isValid) {
 	    Student theStudent = new Student(0, firstName, lastName, email);
 	    
	    try {
 	        studentDb.addStudent(theStudent);
	        
 	        request.setAttribute("firstName", theStudent.getFirstName());
	        request.setAttribute("lastName", theStudent.getLastName());
	        request.setAttribute("email", theStudent.getEmail());

 	        request.getRequestDispatcher("StudentCon.jsp").forward(request, response);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
        else {
        request.setAttribute("errorMessage", errorMessage.toString());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/AddNewStudent1.jsp");
        dispatcher.forward(request, response);
    } 
        
	}

	
}
	
	
	