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
			if(username.equals("admin"))
			{
				response.sendRedirect("login.html");
			}
        }
		%>
<head>
<title>
Add record 
</title>
<script>

function validate()
{
var x=document.getElementById("name").value;
var y=document.getElementById("qualification").value;
var a=document.getElementById("dob").value;
var b=document.getElementById("address").value;
var c=document.getElementById("phone").value;
var ab=document.getElementById("be").value;

if(x=="" && y==""&& a==""&& b==""&& c=="" && ab=="")
 {
   document.getElementById("err").innerHTML=" *** All field are empty";
      return false;
 }
 if(ab=="")
{ 
document.getElementById("err").innerHTML=" *** Please Enter ID";
return false;					
}
if(x=="")
{ 
document.getElementById("err").innerHTML=" *** User name cannot be empty";
return false;					
}
if(y=="")
{ 
document.getElementById("err").innerHTML="*** Qualification cannot be empty ";
return false;					
}

if(b=="")
{ 
document.getElementById("err").innerHTML="*** Address cannot be empty ";
return false;					
}
if (!document.fa.gender[0].checked && !document.fa.gender[1].checked)
{
	document.getElementById("err").innerHTML="*** Please Select Gender ";
	return false;
}
if(a=="")
{ 
document.getElementById("err").innerHTML="*** Please Select Dob ";
return false;					
}

var myDate = new Date(a);
var today = new Date();
if ( myDate > today ) { 
document.getElementById("err").innerHTML="*** Date cannot be greater than today date  ";     
return false;
}

if(c=="")
{ 
document.getElementById("err").innerHTML="*** Phone cannot be empty ";
return false;					
}

if(!(c>="0" && c<="9")){
document.getElementById("err").innerHTML="*** Phone contain only numbers ";
return false;
}
if(c.length < 7)
{
document.getElementById("err").innerHTML="*** Phone number too short ";
return false;
}

}
</script>


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


</head>

<body>


<h1 style="font-family:calibri"> Please Add your Data </h1><br><hr><br>
<h1>Welcome <%=username%></h1>

<div id="err" style="color:red;font-family:calibri"> </div>
<form name="fa" method="post" action="ADDRECORD" onsubmit="return validate()">

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
  <td><label>Qualification:</label></td>
  <td><input type="text" id="qualification" name="qualification"></td>
</tr>
<tr>
  <td><label>Date of Birth:</label></td>
  <td><input type="date" id="dob" name="dob"></td>
  </tr>
  <tr>
  <td><label>Address</label></td>
  <td><input type="address" id="address" name="address"></td>
</tr>
<tr>
  <td><label>Gender:</label></td>
  <td><input type="radio" id="male" name="gender" value="male">
 <label>Male</label>
  <input type="radio" id="female" name="gender" value="female">
  <label>Female</label> </td>

<tr>
  <td><label>Phone Number </label></td>
  <td><input type="text" name="phone" id="phone"></td>
</tr>
<tr>
  <td><label >What you think about me  ??</label></td>
  <td><textarea id="personal_info" name="personal_info"></textarea></td>
</tr>
  </table>
  <br><br>
  
  
  <button type = "button"  class ="design"><a href="user_dashboard.jsp">Back to Dashboard</a></button>
<input class="design" type="submit" value="Submit" id ="Signup" name="signup" />
  <input   class ="design" type="reset" value="Clear" />
	

</form>


</body>

</html>
