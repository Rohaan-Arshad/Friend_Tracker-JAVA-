import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class VIEWRECORDSADMIN extends HttpServlet {
     public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException,NullPointerException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        
         HttpSession sd = request.getSession(false);

        if (sd == null) {
           response.sendRedirect("login.html");
            return;
        }
        String g = (String)sd.getAttribute("USERNAME");
        String f = (String)sd.getAttribute("Email");
        out.println("<h1>Welcome  " + g+ "</h1>");

    try{

    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://127.0.0.1/records";

    Connection con=DriverManager.getConnection(url, "root", "root");

    PreparedStatement pst=con.prepareStatement("SELECT * FROM add_record ");
    
    ResultSet rs = pst.executeQuery();
    ResultSetMetaData rmsd = rs.getMetaData();

out.println("<h1 style=font-family:calibri> All records.... </h1> <br><br> ");
    out.println("<table border = '1' style=font-size:30px>");
    out.println("<tr>");
    int columns = rmsd.getColumnCount();
    String cName;
    for (int i=1; i <= columns; i++)
    {
        cName = rmsd.getColumnName(i);
        out.println("<th>" + cName +"</th>");
    }
    out.println("</tr>");

    String id, name, qualify, dob,addr,gender,ph,note; 
    while (rs.next())
   {
    id = rs.getString(1);
    name = rs.getString(2);
    qualify = rs.getString(3);
    dob = rs.getString(4);
    addr = rs.getString(5);
    gender = rs.getString(6);
    ph = rs.getString(7);
    note = rs.getString(8);

    out.println("<tr>");
    out.println("<td>" + id + "</td>");
    out.println("<td>" + name + "</td>");
    out.println("<td>" + qualify + "</td>");
    out.println("<td>" + dob + "</td>");
    out.println("<td>" + addr + "</td>");
    out.println("<td>" + gender + "</td>");
    out.println("<td>" + ph + "</td>");
    out.println("<td>" + note + "</td>");
    out.println("</tr>");
    }
    out.println("</table>");

    
    }
    catch(Exception e){

      out.println(e);
    }
        out.println("<br><br>");
        if(g.equals("admin"))
        {
            out.println();
             out.println("<button><a href=admin_dashboard.jsp style=text-decoration:none;font-family:calibri;font-size:20px;color:red> Back to main page </a></button>");
        }
        else
        {
             out.println("<button><a href=user_dashboard.jsp style=text-decoration:none;font-family:calibri;font-size:20px;color:red> Back to main page </a></button>");
        }
        out.println("<br><br>");
        
}     


protected void service(HttpServletRequest request, HttpServletResponse   response) throws ServletException, IOException {
        doPost(request, response);
}
}