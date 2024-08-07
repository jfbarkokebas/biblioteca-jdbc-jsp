<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<title>Biblioteca Oasis</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

a {
	text-decoration: none;
	color: #fff;
}

body {
	width: 100%;
	height: 100vh;
	display: flex;
	align-items: center;
	justify-content: center;
	padding: 2rem;
	background-color: #ffffff;
}

.main-container {
	width: 90vw;
	height: 90vh;
	display: flex;
	flex-direction: column;
	border: 1px solid grey;
	background-color: #F2F3F4;
	padding: 1rem;
}

td {
	padding-right: 8px;
}

tr {
	margin-top: 8px;
}

input {
	margin: 4px 0;
	padding: 3px 6px;
}

p {
	background-color: #c0c0c0;
	border-bottom: 1px solid grey;
	padding: 8px;
}

.error-message {
	color: #E74C3C;
	margin-left: 50px;
	font-size: 1.3rem;
}

.table-wrapper {
	padding: 16px 8px;
	border: 1px solid grey;
	border-radius: 6px;
	background-color: #c0c0c0;
	overflow: scroll;
	height: 350px;
}

.descriptionArea {
	display: flex;
	flex-direction: column;
}
</style>
</head>
<body>
	<div class="main-container">

		<p>
			<a class="btn btn-primary" data-bs-toggle="collapse"
				href="#multiCollapseExample1" role="button" aria-expanded="false"
				aria-controls="multiCollapseExample1">Livros</a>
			<button class="btn btn-primary" type="button"
				data-bs-toggle="collapse" data-bs-target="#multiCollapseExample2"
				aria-expanded="false" aria-controls="multiCollapseExample2">Usuários</button>
				<span class="error-message">${msg}</span>
		</p>
		<div class="row">
			<div class="col">
				<jsp:include page="livros.jsp"></jsp:include>
			</div>
			<div class="col">
				<jsp:include page="usuarios.jsp"></jsp:include>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
		crossorigin="anonymous">
		
	</script>
	<script type="text/javascript">
		var myCollapse = document.getElementById('myCollapse')
		var bsCollapse = new bootstrap.Collapse(myCollapse, {
			toggle : false
		})
	</script>
</body>
</html>