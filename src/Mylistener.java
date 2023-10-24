import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
/*
 * 
 */

public class Mylistener  implements ServletContextListener{


	@Override
	/*
	 * (non-Javadoc)
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
	 * @param value the arg0
	 * @return the value in which the user added with the resultset
	 */
	public void contextInitialized(ServletContextEvent arg0) {
		
		ArrayList<User> list=new ArrayList<>();
		
		String jdbcurl="jdbc:mysql://localhost:3306/servlet_connect";
		String username="root";
		String password="mysql";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=(Connection) DriverManager.getConnection(jdbcurl,username,password);
			
			String sql="select * from userinfo";
			PreparedStatement statement=(PreparedStatement) connection.prepareStatement(sql);
			ResultSet resultset=statement.executeQuery();
			while (resultset.next()){
				User Userinfo=new User();
				Userinfo.setId(resultset.getInt(1));
				Userinfo.setUsername(resultset.getString(2));
				Userinfo.setPassword(resultset.getString(3));
				list.add(Userinfo);
				
			}
			connection.close();
			
			
		}catch (Exception ex) {
			
			System.out.print(ex);
			// TODO: handle exception
		}
		 //storing the ArrayList object in ServletContext 
		//calling the servlet event arg0
		   ServletContext context=arg0.getServletContext();  
		   context.setAttribute("data",list);  
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg) {
		System.out.println("project undeployeds");
		
		// TODO Auto-generated method stub
		
	}


}
