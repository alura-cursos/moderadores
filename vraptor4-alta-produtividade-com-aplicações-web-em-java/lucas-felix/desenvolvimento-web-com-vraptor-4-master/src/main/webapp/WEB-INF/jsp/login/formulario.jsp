<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Formulario de Login</title>
</head>
<body>
	<form action="<c:url value='/login/autentica'/>" method="post">
		<input type="text" name="usuario.nome"/>
		<input type="text" name="usuario.senha"/>
		<input type="submit" value="Login">
	</form>
	
	<c:forEach items="${errors}" var="erro">
		${erro.category} - ${erro.message} <br>
	</c:forEach>
</body>
</html>