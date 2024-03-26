import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class DELETEUSERRECORD extends HttpServlet {
     public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
    PrintWriter out = response.getWriter();

  HttpSession sd = request.getSession(false);
  if (sd == null) {
           response.sendRedirect("login.html");
            return;
        }
  String g = (String)sd.getAttribute("USERNAME");
  String f = (String)sd.getAttribute("Email");
  String i = (String)sd.getAttribute("ID");


  if(g.equals("admin"))
  {
        RequestDispatcher d=request.getRequestDispatcher("/login.jsp");  
				d.include(request, response);
                return;
  }


    String id=request.getParameter("be1");
    if(id=="")
    {
        out.println("<h1>Please Enter ID </h1>");
        return ;
    }
    
     if(id.equals(i))
    {

        friendDAO fr=new friendDAO();
        int r = fr.delete_user(id);
        if(r>=1)
        {
                response.sendRedirect("user_dashboard.jsp");
        }
    }
    else
    {
         out.println(" <h3 style=color:red;font-family:calibri>Please give your id.. </h3>");  
		RequestDispatcher rd=request.getRequestDispatcher("/delete_user.jsp");  
		rd.include(request, response);
    }
     }
     public void service(HttpServletRequest request, HttpServletResponse   response) throws ServletException, IOException {
        doPost(request, response);
}
}     