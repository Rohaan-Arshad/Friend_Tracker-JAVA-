import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.sql.*;

public class LOGIN extends HttpServlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException
    {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if(email=="" && password=="")
                {
                    out.println("<h1>All fields are empty.. </h1>");
                    return ;
                }
                else if(email==""){
                     out.println("<h1>Email cannot be empty .. </h1>");
                    return ;
                }
				else if(password==""){
                     out.println("<h1>Password cannot be empty ..  </h1>");
                    return ;
                }
				else if(password.length()<=6)
                {
                     out.println("<h1>Password must contain 7 characters  ..  </h1>");
                    return ;
                }
				
				var at=email.indexOf("@");  
                var dot=email.lastIndexOf(".");  
                if (at<1 || dot<at+2 || dot+2>=email.length())
                {
                    out.println("<h1>Email format not correct ..   </h1>");
                    return ;
                }

        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1/class_test";
            Connection con = DriverManager.getConnection(url,"root","root");
            Statement st= con.createStatement();
			
			
            String query = "Select * from info";
            ResultSet rs = st.executeQuery(query);

            while(rs.next())
            {
                String mail = rs.getString("Email");
                String passcode = rs.getString("Password");
				String user = rs.getString("Username");
				
                if(mail.equals(email))
                {
					if(passcode.equals(password))
					{
                        HttpSession sd = request.getSession(true);
                        sd.setAttribute("USERNAME",user);
                        sd.setAttribute("Email",mail);

                        if(user.equals("admin"))
                        {
                            response.sendRedirect("admin_dashboard.jsp");
                            return;
                        }
                        else if(!user.equals("admin"))
                        {
                            response.sendRedirect("user_dashboard.jsp");
                            return;
                        }
					}
					else if(!passcode.equals(password))
					{
						out.println("<br>");
						out.println(" <h3 style=color:red;font-family:calibri>Invalid Passoword Enter ! </h3>");  
						RequestDispatcher rd=request.getRequestDispatcher("/login.html");  
						rd.include(request, response);
						return;						
					} 
                }
            }    
				out.println("<br>");
				out.println(" <h3 style=color:red;font-family:calibri>Please Sign up ! Data not exsist.... </h3>");  
				RequestDispatcher rd=request.getRequestDispatcher("/login.html");  
				rd.include(request, response);

                st.close();
                con.close();
        }    
            catch(Exception e){
            out.println(e);
        }
}

protected void service(HttpServletRequest request, HttpServletResponse   response) throws ServletException, IOException {
        doPost(request, response);
}

}


