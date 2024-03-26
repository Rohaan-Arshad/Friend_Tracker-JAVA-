<!DOCTYPE html>
<html lang="en">

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
			if(username.equals("admin"))
			{
				response.sendRedirect("login.html");
			}
        }
		%>
<head>

<title>
User Dashboard
</title>

<style rel="stylesheet">
    
   
    a{
        text-decoration: none;
        color:rgb(255, 0, 98);
        size: 100px;

    }
    .di{
        text-align: center;
    }
    .design
    {
        size: 100px;
        font-size: larger;
        padding: 10px;
    }
    input
    {
        color:rgb(255, 0, 98);
    }
    h1{
        color:rgb(255, 0, 98);
    }
    form
    {
        display: inline;
    }
    
</style>


</head>
<body>
<br>

<h1>Welcome <%=username%></h1>

<div class="di">
<button type = "button" class="design" ><a href="add_record.jsp">Add Record</a></button>
<button type = "button" class="design" ><a href="delete_user.jsp">Delete Record</a></button>


<form  action="VIEWRECORDSADMIN" method="post">
<input type = "submit" class="design" value="View All Records" >
</form>

<form  action="LOGOUT" method="post">
    <input type = "submit" class="design" value="Log Out" >
    </form>

</div>
</body>
</html>