<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 
<form method="post" action="QuizServlet">
<h3>Have fun with NumberQuiz!</h3>
        <p>Your current score is: ${score}
        <p>Guess the next number in the sequence!
        ${curQuest}</p>

        <p>Your answer:<input type='text' name='txtAnswer' value='' /></p>

        <!-- /* if incorrect, then print out error message */ -->
        <!-- if (error && (answer != null)) {  //REFACTOR?-- assumes answer null only when first open page
            out.print("<p style='color:red'>Your last answer was not correct! Please try again</p> ");
        }
 -->    <p><input type='submit' name='btnNext' value='Next' /></p>

        </form>
      </body></html>
</body>
</html>