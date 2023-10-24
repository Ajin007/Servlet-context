import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLDocument.Iterator;

	
	public class MyServlet2 extends HttpServlet {  
		 public void doGet(HttpServletRequest request, HttpServletResponse  
		   response)throws ServletException, IOException {  
		  
		    response.setContentType("text/html");  
		    PrintWriter out = response.getWriter();  
		      
		    long before=System.currentTimeMillis();  
		          
		    ServletContext context=getServletContext();  
		    List<User> list=(List<User>)context.getAttribute("data");  
		          
		    java.util.Iterator<User> itr=list.iterator();  
		    while(itr.hasNext()){  
		     User u=(User)itr.next();  
		     out.print("<br>"+u.getId()+" "+u.getUsername()+" "+u.getPassword());  
		    }  
		          
		    long after=System.currentTimeMillis();  
		    out.print("<br>total time :"+(after-before));  
		          
		    out.close();  
		    }  
		  
		}  
