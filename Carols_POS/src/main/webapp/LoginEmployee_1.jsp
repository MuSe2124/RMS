<%-- 
    Document   : LoginEmployee
    Created on : 10 Jun 2022, 10:48:20
    Author     : muaad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee login</title>
        <style>


.bars{
border-radius:5px;
border:none;
font-size:25px;
background-color:lightgrey;
}
#midbody{
font-size:25px;
background-color:white;
text-align:center;
width:450px;
height:550px;
position:absolute;
top:80px;
left:480px;
border:solid 2px grey;
}

#id{
  font-size:20px;
  background-color:white;
  border:1px solid black;
}
#header{
font-size:30px;
Position:fixed;
top:0;
left:0;
text-align:center;
background-color:blue;
width:100%;
}
#aline{
Position:fixed;
left:0px;
width:50;
height:10px;
background-color:blue;
border-radius: 20px;
}

.button{
  background-color: rgb(0, 0, 128);
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;

  font-size: 18px;

  width:300px;
  transition-duration: all 0.1s;
  cursor: pointer;
}
#H{
position:absolute;
left:600px;
top:10px;
}
.button:hover {
  background-color: rgb(0, 0, 80);
}
.button:active{
  background-color:rgb(0,0,50);
}
        </style>
    </head>
    <body style ="background-color:rgb(204, 224, 255)">
        <% String loginResponseMessage = (String)request.getAttribute("loginResponseMessage"); %>
        <h1 id="H">Carols Boutique</h1>
        <br>
        <br>
        <br>
        <div  id ="midbody" style="background-image:url('https://lh3.googleusercontent.com/pw/AM-JKLXMO5yDb4rwt4sEQrgiQOMODT_pJfb1SL2dd8vpb9xK6qq-v0-sLTcA7ci2YTgbCEc9EH-VWq56ksYL1wsRQOFNAtSXfc6cmCOwCtpfS-Hbcj4rYphCA-b4AYxOAjboLEyfbJ4HxwYWuwhl5jRgETc=w1095-h657-no?authuser=0'); background-size:cover;">
            <form action="EmployeeServlet" method="post">
            <br>
            <h2><u>Login employee</u></h2><br>
            <label>Employee ID number:</label><br>
            <input type="text" class="bars" id="empID" name="empID" placeholder ="253"><br><br>
            <label>Password:</label><br>
            <input type="text" class ="bars" id="empPass" name="empPass" placeholder ="password"><br><br>
            <br>
            <input type= "submit" class="button"  id ="login" name = "submit" value ="login"><br>
            <br>
            <%if(loginResponseMessage != null){%>
            <label><%=loginResponseMessage%></label>
            <%}%>
            </form>
        </div>

    </form>
</body>
</html>
