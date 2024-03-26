<html>
    <%@ page session="false"%>
	<% HttpSession session = request.getSession(false);
        String username=null;
		if(session==null)
		{
			response.sendRedirect("login.html");
		}
        else if(session!=null)
		{
			String type = (String)session.getAttribute("Email");
            username = (String)session.getAttribute("USERNAME");
			if(!username.equals("admin"))
			{
				response.sendRedirect("login.html");
			}
        }
		%>
<head>
    <title>
        Update Record
    </title>
    <style rel="stylesheet">
        .design{
        font-family:calibri;
        font-size:27px;
        text-align: center;
        margin:auto;
        }
        body{
        text-align:center;
        }
        a{
        text-decoration:none;
        color:black;
        }
        td{
        padding: 12px;
        }
        </style>
        <script>
          function validate()
          {
              var x=document.getElementById("be").value;
              var y=document.getElementById("name").value;
              var z=document.getElementById("address").value;
              var a=document.getElementById("phone").value;
              var b=document.getElementById("qualify").value;
            
              if(x=="" && y==""&& z==""&& a==""&& b=="")
              {
                  document.getElementById("err").innerHTML="All fields are empty ";
                  return false;
              }

              if(x=="")
              {
                  document.getElementById("err").innerHTML="Please Enter ID";
                  return false;
              }
              else if(y=="")
              {
                  document.getElementById("err").innerHTML="Please Enter Name";
                  return false;
              }
              else if(z=="")
              {
                  document.getElementById("err").innerHTML="Please Enter Address";
                  return false;
              }
              else if(a=="")
              {
                  document.getElementById("err").innerHTML="Please Enter Phone Number";
                  return false;
              }
              else if(b=="")
              {
                  document.getElementById("err").innerHTML="Please Enter Qualification";
                  return false;
              }
              if(!(a>="0" && a<="9")){
                    document.getElementById("err").innerHTML="*** Phone contain only numbers ";
                    return false;
              }
          }
      </script>
</head>

<body>
    <h1> Update </h1><br><br>
    <h1>Welcome <%=username%></h1>
    <b><div id="err" name="error" style="color:red;font-family:calibri;text-align:center"></div></b><br><br>
    <form action="UPDATEADMIN" method="post" onsubmit="return validate()">
<table class="design">
    <tr>
        <td><label>Enter ID:</label></td>
       <td> <input type="text" id="be" name="be1"></td>
        </tr>
        
      <tr>
        <td><label>Full Name:</label></td>
       <td> <input type="text" id="name" name="name"></td>
        </tr>

        <tr>
            <td><label>Address</label></td>
            <td><input type="address" id="address" name="address"></td>
          </tr>

        <tr>
            <td><label>Phone Number </label></td>
            <td><input type="text" name="phone" id="phone"></td>
          </tr>

          <tr>
            <td><label>Qualification </label></td>
            <td><input type="text" name="qualify" id="qualify"></td>
          </tr>
    </table><br><br>

    <button type = "button"  class ="design"><a href="admin_dashboard.jsp">Back to Dashboard</a></button>
    <input class="design" type="submit" value="Update" id ="Signup" name="signup" />
      <input   class ="design" type="reset" value="Clear" />
</form>

</body>
</html>