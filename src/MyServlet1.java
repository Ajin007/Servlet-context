import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyServlet1 extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse  
			   response)throws ServletException, IOException{
		
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
	    
	    long before=System.currentTimeMillis();
	    
	    
	    ServletContext context=getServletContext();  
	    List<User> list=(List<User>)context.getAttribute("data");  
	    
	    for(User u: list){
	    	out.print("<br>"+u.getId()+u.getUsername()+u.getPassword());
	    	
	    }
	    long after = System.currentTimeMillis();
        out.print("<br>total time: " + (after - before));
	}

}
