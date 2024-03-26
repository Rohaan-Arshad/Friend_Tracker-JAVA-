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
            Delete Record
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
    
                    if(x=="")
                    {
                        document.getElementById("err").innerHTML="Please Enter ID";
                        return false;
                    }
    
                }
            </script>
    </head>

    <body>
        <h1>Delete</h1>
        <h1>Welcome <%=username%></h1> 
        <b><div id="err" name="error" style="color:red;font-family:calibri;text-align:center"></div></b>

        <form action="DELETEADMIN" method="post" onsubmit="return validate()">
        <table class="design">
            <tr>
                <td><label>Enter ID:</label></td>
               <td> <input type="text" id="be" name="be1"></td>
                </tr>
         </table><br><br>

         <button type = "button"  class ="design"><a href="admin_dashboard.jsp">Back to Dashboard</a></button>
         <input class="design" type="submit" value="Delete" id ="Signup" name="signup" />
           <input   class ="design" type="reset" value="Clear" />
        </form>
         
    </body>
</html>