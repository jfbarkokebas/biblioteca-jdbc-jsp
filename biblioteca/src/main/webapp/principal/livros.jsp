<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="collapse multi-collapse" id="multiCollapseExample1">
	<div class="card card-body">
		<div class="formUsuario">
			<h2>Cadastrar Livro</h2>
			<form action="UserController" method="POST">
				<table class="create-user-table">
					<tr>
						<td>Título:</td>
						<td><input type="text" name="titulo" id="input-usuario"></td>
						<td>Autor:</td>
						<td><input type="email" name="email" id="input-email"></td>
					</tr>
					<tr>
						<td>Publicado em:</td>
						<td><input type="number" name="publicado" id="input-senha"></td>
						<td>ISBN:</td>
						<td><input type="text" name="confirmacao"
							id="input-confirme-senha"></td>
					</tr>
				</table>
				<div class="descriptionArea">
					<label>Descrição:</label>
					<textarea rows="3" cols="10" name="descricao" style="resize: none" ></textarea>
				</div>
				<input type="submit" value="CADASTRAR" class="btn btn-primary"
					style="margin-top: 15px;">
			</form>
		</div>
		<div class="table-users">
		<br>
		<h1>Lista de Livros</h1>
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