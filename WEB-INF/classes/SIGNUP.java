import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class SIGNUP extends HttpServlet {
	
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();

    String name=request.getParameter("username");
    String email=request.getParameter("email");
    String password=request.getParameter("password");
    String cn_password=request.getParameter("cn_password");

    if(name=="" && email=="" && password=="" && cn_password=="")
    {
      out.println("<h1> All fields are empty !! </h1>");
      return ;
    }
    else if(name.equals("admin") ||  name.equals("Admin")){
     out.println("<h1> Sorry this User Name you cannot Select please choose other name..  </h1>");
       return ;
     }
    else if(email=="")
    {
      out.println("<h1> Please Enter Email   </h1>");
      return ;
    }
    else if(password=="")
    {
      out.println("<h1> Please Enter Password   </h1>");
      return ;
    }
    else if(cn_password=="")
    {
      out.println("<h1> Please Enter Confirm  Password   </h1>");
      return ;
    }
    else if(password.length()<=6)
    {
      out.println("<h1> Password must contain 7 characters ..</h1>");
      return ;
    }
    else if(cn_password.length()<=6)
    {
      out.println("<h1> Confirm Password must contain 7 characters ..</h1>");
      return ;
    }
    else if (!password.equals(cn_password))
    {
      out.println("<h1> Password and Confirm Password not match ..    </h1>");
      return ;
    }
    var at=email.indexOf("@");  
    var dot=email.lastIndexOf(".");  
    if (at<1 || dot<at+2 || dot+2>=email.length())
    {
        out.println("<h1> Email format not correct  ..</h1>");
        return ;
    }


    
    friendDAO fr = new friendDAO();
    boolean f = fr.check_email(email);
    if(f)
    {
      out.println("<h1> Email cannot be Same ... </h1>");
      return;
    }
    else
    {
      int i= fr.signup(name,email,password,cn_password);
        if(i>=1)
        {
          response.sendRedirect("login.html");
        }
    }
    
  }

}