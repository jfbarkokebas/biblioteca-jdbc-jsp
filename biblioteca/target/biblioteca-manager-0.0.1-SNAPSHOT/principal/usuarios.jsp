<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="collapse multi-collapse" id="multiCollapseExample2">
	<div class="card card-body">
		<div class="formUsuario">
			<h2>Cadastro de Usuário</h2>
			<form action="UserController" method="POST">
				<table class="create-user-table">
					<tr>
						<td>Nome Completo:</td>
						<td><input type="text" name="nome" id="input-usuario"></td>
						<td>Email:</td>
						<td><input type="email" name="email" id="input-email"></td>
					</tr>
					<tr>
						<td>Senha:</td>
						<td><input type="password" name="senha" id="input-senha"></td>
						<td>Confirmar Senha:</td>
						<td><input type="password" name="confirmacao"
							id="input-confirme-senha"></td>
					</tr>
					<tr>
						<td>WhatsApp:</td>
						<td><input type="number" name="whatsapp"
							placeholder="só use numeros"></td>
						<td>Telefone:</td>
						<td><input type="number" name="telefone"
							placeholder="só use numeros"></td>
					</tr>
				</table>
				<input type="submit" value="CADASTRAR" class="btn btn-primary"
					style="margin-top: 15px;">
			</form>
		</div>
		<div class="table-users">
		<br>
		<h1>Lista de Usuários</h1>
			<p style="margin-bottom: 10px">
			
			<a class="btn btn-primary" href="UserController">Carregar</a>
			</p>


			<div class="table-wrapper">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">id</th>
							<th scope="col">Nome</th>
							<th scope="col">Telefone</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="user" items="${sessionScope.userList}">
							<tr>
								<td>${user.id}</td>
								<td>${user.name}</td>
								<td>${user.phone}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</div>