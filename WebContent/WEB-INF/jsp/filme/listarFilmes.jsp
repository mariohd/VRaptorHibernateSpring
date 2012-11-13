<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>Código</td>
			<td>Titulo</td>
			<td>Ano</td>
		</tr>
		<c:forEach items="${filmeList }" var="filme">
			<tr>
				<td>${filme.codigo }</td>
				<td>${filme.titulo }</td>
				<td>${filme.ano }</td>
				<td><form
						action='<c:url value='/filme/excluir/${filme.codigo }' />' method="post" >
						<input type="hidden" value=${filme.titulo } name=filme.titulo>
						<input type="hidden" value=${filme.ano } name=filme.ano>
						<button type="submit">excluir</button>
					</form></td>
			</tr>
		</c:forEach>
	</table>
	<form action='<c:url value='/filme/novo' />' method="get">
		<table border="0">
			<tr>
				<td>Titulo</td>
				<td><input type="text" name='novoFilme.titulo' /></td>
			</tr>
			<tr>
				<td>Ano</td>
				<td><input type="text" name='novoFilme.ano' /></td>
			</tr>
		</table>
		<button type="submit">Confirmar</button>
	</form>
</body>
</html>