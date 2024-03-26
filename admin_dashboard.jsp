
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
Admin Dashboard
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
    <h1>Welcome <%=username%></h1> 

<div class="di">
<br>
<button type = "button" class="design" ><a href="admin_update_record.jsp">Update Record</a></button>
<button type = "button" class="design" ><a href="admin_delete_record.jsp">Delete Record</a></button>

<form  action="VIEWRECORDSADMIN" method="post">
    <input type = "submit" class="design" value="View All Records" >
    </form>

    <form  action="LOGOUT" method="post">
        <input type = "submit" class="design" value="Log Out" >
        </form>
</div>
</body>
</html>