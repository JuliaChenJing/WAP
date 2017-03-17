
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Number Quiz JSP</title>
</head>
<body>

	<form method="post" action="QuizServlet">
		<h3>Have fun with NumberQuiz!</h3>
		<p>Your current score is: ${score}
		<p>Guess the next number in the sequence! ${curQuest}</p>

		<p>
			Your answer:<input type='text' name='txtAnswer' value='' />
		</p>
			YOUR AGE: <input type="text" name="age" ${disable} value="${ageValue}"/> 
	
			<p style='color: red'>${errorAge}</p>
	
		<p style='color: red'>${error}</p>
	
		<p>
			<input type='submit' name='btnNext' value='Next' />
		</p>
	</form>
	<button id="hint" value="${hint}">Hint ?</button>
	
	<form action="QuizServlet">
	</form>
	
	
</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$("#hint").click(function() {
			alert($(this).attr('value'));;
		});
	});
</script>
</html>
</body>
</html>