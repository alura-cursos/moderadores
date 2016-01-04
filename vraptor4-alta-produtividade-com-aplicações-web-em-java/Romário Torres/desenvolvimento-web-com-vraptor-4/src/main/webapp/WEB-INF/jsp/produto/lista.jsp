<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"
	href="../bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href=".css/base.css">
<title>Lista de Produtos</title>
</head>
<body>
	<div class="container">
		<h4>Listagem de Produtos do ${usuarioLogado.usuario.nome}</h4>
		<table class="table table-stripped table-hover table-bordered">
			<thead>
				<tr>
					<th>Nome</th>
					<th>Valor</th>
					<th>Quantidade</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${produtoList}" var="produto">
					<tr>
						<td>${produto.nome}</td>
						<td>${produto.valor}</td>
						<td>${produto.quantidade}</td>
						<td>
							<c:url value="/produto/enviaPedidoDeNovosItens?produto.nome=${produto.nome}" var="url"/>
							<a href="${url}">Pedir mais itens!</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<c:if test="${not empty mensagem}">
			<div class="alert alert-success" role="alert">
				${mensagem}
			</div>
		</c:if>
	</div>
</body>
</html>