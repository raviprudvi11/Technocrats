<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Login</h1>
	${ SPRING_SECURITY_LAST_EXCEPTION.message}
	<form action="login" method ='POST'>
	
	<table>
            <tr>
                <td >User Name :</td><td><input type="text" name="username" value="" />
                </td>
            </tr>
            <tr>
                <td >Password  :</td><td><input type="password" name="password" value=""  />
                </td>
            </tr>
            <tr>
                <td>
                    <input type="submit" name="login" value="Log In" style="font-size:18px; " />
                </td>
            </tr>
        </table>
        </form>
   </body>
  </html>    
        

