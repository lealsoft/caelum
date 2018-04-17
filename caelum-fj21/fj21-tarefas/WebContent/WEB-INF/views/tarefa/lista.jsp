
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="s" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<title>Insert title here</title>
</head>
<body>
<c:import url="../cabecalho.jsp"></c:import>
<a href="novaTarefa">Criar nova tarefa.</a>
<br>
<br>
<table class="table table-striped table-hover table-sm">
	<thead class="thead-dark">
	<tr>
		<th>ID</th>
		<th>Descrição</th>
		<th>Finalizado?</th>
		<th>Data de Finalização</th>
		<th>Ações</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach items="${tarefas}" var="tarefa">
		<tr id="linha_${tarefa.id}">
			<td>${tarefa.id}</td>
			<td>${tarefa.descricao}</td>
			<c:if test="${tarefa.finalizado eq false}">
				<td id="status_${tarefa.id}">Não finalizado</td>
			</c:if>
			<c:if test="${tarefa.finalizado eq true}">
				<td id="status_${tarefa.id}">Finalizado</td>
			</c:if>
			<td>
				<f:formatDate value="${tarefa.dataFinalizacao.time}" pattern="dd/mm/yyyy"/>
			</td>
			<td><a href="excluirContato/?id=${contato.id}">excluir</a> | <a href="#" onClick="finalizaTarefa(${tarefa.id});">finalizar</a></td>
		</tr>
	</c:forEach>
	</tbody>
</table>
<script>
	/*	
	(function($) {
		remove = function(item) {
			alert('oi');
			var tr = $(item).closest('tr');
			tr.fadeOut(400, function() {
				tr.remove();
			});	
			return false;
			
		}
	})(jQuery);
	*/
	function finalizaTarefa(id) {
		$.get("finalizaTarefas?id="+id, function(){
			alert('Finalizado.');
			$("#status_"+id).html("Finaliado!");
		})
	}
</script>   
<c:import url="../rodape.jsp"></c:import>
</body>
</html>