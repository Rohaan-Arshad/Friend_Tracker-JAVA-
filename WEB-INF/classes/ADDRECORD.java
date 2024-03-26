import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class ADDRECORD extends HttpServlet {
	
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();

  HttpSession sd = request.getSession(false); 
  String g = (String)sd.getAttribute("USERNAME");
  String f = (String)sd.getAttribute("Email");

  if(g.equals("admin"))
  {
        RequestDispatcher rd=request.getRequestDispatcher("/login.html");  
				rd.include(request, response);
  }
  else
  {
    String id=request.getParameter("be1");
    String name=request.getParameter("name");
    String qualify=request.getParameter("qualification");
    String dob=request.getParameter("dob");
	  String address=request.getParameter("address");
	  String gender=request.getParameter("gender");
	  String phone=request.getParameter("phone");
	  String note=request.getParameter("personal_info");

    sd.setAttribute("ID",id);

    if(id=="" && name==""&& qualify==""&& dob==""&& address=="" && gender=="")
        {
            out.println("<h1> All fields are empty </h1>");
        }
        if(id=="")
      { 
        out.println("<h1> Please Enter ID </h1>");
        return ;
      }					
      if(name=="")
      { 
       out.println("<h1> Please Enter Name </h1>");
        return ;					
      }
      if(qualify=="")
      { 
       out.println("<h1> Please Enter Qualification  </h1>");
        return ;					
      }

      if(dob=="")
      { 
       out.println("<h1> Please Select DOB  </h1>");
      return ;					
      }
      if ((gender == null || (!gender.equals("male") && !gender.equals("female"))))
      {
      	 out.println("<h1> Please Select Gender  </h1>");
      	return ;
      }
      if(phone=="")
      { 
       out.println("<h1> Please Enter Phone Number .. </h1>");
      return ;					
      }

      if(address=="")
      { 
       out.println("<h1> Please Enter Address .. </h1>");
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
      out.println("<h1> ID already exsist  ... </h1>");
      return;
    }
    else
    {
      int i= fr.add_record(id,name,qualify,dob,address,gender,phone,note);
        if(i>=1)
        {
          response.sendRedirect("user_dashboard.jsp");
        }
    }
    
  } 
  }

}