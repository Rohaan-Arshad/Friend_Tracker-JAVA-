import java.sql.*;
import java.util.*;
public class friendDAO {


    public boolean check_email(String email)
    {boolean b= false;
        try{

    Class.forName("com.mysql.jdbc.Driver");
    String url = "jdbc:mysql://127.0.0.1/class_test";
    Connection con=DriverManager.getConnection(url, "root", "root");
    Statement st=con.createStatement();
    String query1 = "SELECT Email FROM info WHERE email=  '" +email+ "' ";
    ResultSet rs = st.executeQuery(query1);
    if(rs.next())
    {
      b=true;
    }
    st.close();
        }
        catch(Exception e)
    {
      System.out.println(e);
    }
    return b;
    }


    public int signup(String name,String email,String password,String cn_password)
    {int r=0;
        try{

    Class.forName("com.mysql.jdbc.Driver");
    String url = "jdbc:mysql://127.0.0.1/class_test";
    Connection con=DriverManager.getConnection(url, "root", "root");
    Statement st=con.createStatement();

    String query = "insert into info(Username,Email,Password,Confirm_Password) values('"+name+"', '"+email+"', '"+password+"', '"+cn_password+"' )";
     r = st.executeUpdate( query );
        st.close();
        con.close();
    }
    catch(Exception e)
    {
      System.out.println(e);
    }
    return r;
    }

    public boolean check_id(String id)
    {boolean b= false;
        try{
     Class.forName("com.mysql.jdbc.Driver");
    String url = "jdbc:mysql://127.0.0.1/records";
    Connection con=DriverManager.getConnection(url, "root", "root");
    PreparedStatement pst=con.prepareStatement("SELECT ID FROM add_record WHERE ID=? ");
	pst.setString(1,id);
    ResultSet rs = pst.executeQuery();
    if(rs.next())
    {
      b=true;
    }
    
    pst.close();
        }
        catch(Exception e)
    {
      System.out.println(e);
    }
    return b;
    }

     public int add_record(String id,String name,String qualify,String dob,String address,String gender,String phone,String note)
     {
        int r=0;
    try{
     Class.forName("com.mysql.jdbc.Driver");
    String url = "jdbc:mysql://127.0.0.1/records";
    Connection con=DriverManager.getConnection(url, "root", "root");

    String query = "insert into add_record(ID,Name,Qualification,DOB,Address,Gender,Phone,Note) values(?,?,?,?,?,?,?,?)";
  	PreparedStatement ps=con.prepareStatement(query);
	
	ps.setString(1,id);
	ps.setString(2,name);
  	ps.setString(3,qualify);
  	ps.setString(4,dob);
  	ps.setString(5,address);
    ps.setString(6,gender);
  	ps.setString(7,phone);
  	ps.setString(8,note);
     r = ps.executeUpdate();
           ps.close();
           con.close();
    }
    catch(Exception e){

      System.out.println(e);
    }
    return r;
  }

  public int delete_user(String id)
  {int r=0;
        try{

    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://127.0.0.1/records";

    Connection con=DriverManager.getConnection(url, "root", "root");


    String query = "DELETE from add_record where id=?";
	PreparedStatement ps=con.prepareStatement(query);

    ps.setString(1,id);

    r = ps.executeUpdate();

           ps.close();
           con.close();
    }
    catch(Exception e){
    }
    return r;
  } 


  public int delete_admin(String id)
  {int r=0;
        try{

    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://127.0.0.1/records";

    Connection con=DriverManager.getConnection(url, "root", "root");


     String query = "DELETE from add_record where id=?";
	PreparedStatement ps=con.prepareStatement(query);

    ps.setString(1,id);

     r = ps.executeUpdate();

           ps.close();
           con.close();
    }
    catch(Exception e){

      System.out.println(e);
    }
    return r;
  } 

  public int update_admin(String id,String name,String phone,String address,String qualify)
  {int r=0;
    try{

    Class.forName("com.mysql.jdbc.Driver");
    String url = "jdbc:mysql://127.0.0.1/records";
    Connection con=DriverManager.getConnection(url, "root", "root");
   
     String query = "UPDATE add_record SET Name = ? ,Phone = ?, Address = ?, Qualification = ? WHERE ID = ? ";
	  PreparedStatement ps=con.prepareStatement(query);
    ps.setString(1,name);
    ps.setString(2,phone);
    ps.setString(3,address);
    ps.setString(4,qualify);
    ps.setString(5,id);
    r = ps.executeUpdate();

           ps.close();
           con.close();}
    catch(Exception e){

      System.out.println(e);
    }
    return r;
  }

}
