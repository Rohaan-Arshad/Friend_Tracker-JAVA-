import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class DELETEADMIN extends HttpServlet {
     public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
    PrintWriter out = response.getWriter();

  HttpSession sd = request.getSession(false);
  String g = (String)sd.getAttribute("USERNAME");
  String f = (String)sd.getAttribute("Email");

  

  if(!g.equals("admin"))
  {
        RequestDispatcher d=request.getRequestDispatcher("/login.html");  
				d.include(request, response);
  }
  else
{
    String id=request.getParameter("be1");
     if(id=="")
    {
       out.println("<h1> PLease Enter ID .. </h1>");
        return ;
     }

    friendDAO fr = new friendDAO();
    boolean fre = fr.check_id(id);
    if(fre)
    {
      int i= fr.delete_admin(id);
        if(i>=1)
        {
          response.sendRedirect("admin_dashboard.jsp");
        } 
    }
    else
    {
      out.println("<h1> Person you are deleting not exsist in database .. </h1>");
      return;
      
    }
}
     }
}     