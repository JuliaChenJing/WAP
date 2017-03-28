<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
test.jsp

<form method=POST action="TestServlet">
Select beer characteristics<p>
Can Sizes: <p>
<input type=checkbox name=sizes value="12oz"> 12 oz.<br>
<input type=checkbox name=sizes value="16oz"> 16 oz.<br>
<input type=checkbox name=sizes value="22oz"> 22 oz.<br>
<br><br>
<center>
<input type="submit"
	 value="submit">
</center>
</form>
</body>
</html>