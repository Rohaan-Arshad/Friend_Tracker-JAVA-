import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class UPDATEADMIN extends HttpServlet {
     public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    HttpSession sd = request.getSession(false);
    
  String g = (String)sd.getAttribute("USERNAME");
  String f = (String)sd.getAttribute("Email");

  if(!g.equals("admin"))
  {
        RequestDispatcher d=request.getRequestDispatcher("/login.html");  
				d.forward(request, response);
  }
  else
  {

    String id=request.getParameter("be1");
    String name=request.getParameter("name");
    String phone=request.getParameter("phone");
    String address=request.getParameter("address");
    String qualify=request.getParameter("qualify");

    if(id =="")
    {
        out.println("<h1> PLease Enter ID .. </h1>");
        return ;
    }
    else if(name=="")
    {
        out.println("<h1> PLease Enter Name  .. </h1>");
        return ;
    }
    else if(phone=="")
    {
        out.println("<h1> PLease Enter Phone Number  .. </h1>");
        return ;
    }
    else if(address=="")
    {
       out.println("<h1> PLease Enter Address .. </h1>");
        return ;
    }
    else if(qualify=="")
    {
         out.println("<h1> PLease Enter Qualification  .. </h1>");
        return ;
    }
    if(!phone.matches("[0-9]+")){
         out.println("<h1> Phone number format contain only numbers .  .. </h1>");
          return ;
    }


    friendDAO fr = new friendDAO();
    boolean fre = fr.check_id(id);
    if(fre)
    {
      int i= fr.update_admin(id,name,phone,address,qualify);
        if(i>=1)
        {
          response.sendRedirect("admin_dashboard.jsp");
        }
    }
    else
    {
      out.println("<h1> Person you are updating not exsist in database   ... </h1>");
      return;
    }


  }
     }
}     