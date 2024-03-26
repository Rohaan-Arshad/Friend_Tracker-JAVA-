import java.sql.*;
import java.util.*;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;

public class LOGOUT extends HttpServlet {
public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  
	{        
		PrintWriter out = response.getWriter();
		HttpSession session=request.getSession(false);
		if(session!=null){
			session.invalidate();
			response.sendRedirect("login.html");
		}
		out.close(); 
	}
}