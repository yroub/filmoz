<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="../../js/commun.js"></script>
<link rel="stylesheet" href="../../css/commun.css">

<style type="text/css">
.centre {
	text-align: center;
}

img {
	vertical-align: bottom;
}
</style>
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a href="../../index.html" class="navbar-brand active"> <span
					class="glyphicon glyphicon-film"></span> <span
					class="glyphicon glyphicon-film"></span>
				</a>
				<button class="navbar-toggle" type="button" data-toggle="collapse"
					data-target="#navbar-main">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
			</div>
			<div class="navbar-collapse collapse" id="navbar-main">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="../../index.html">Accueil</a></li>
					<li><a href="lister">Liste des films</a></li>
					<li><a href="ajouter">Ajouter un film</a></li>
					<li class="active"><a href="#">Styles</a></li>
					<li><a href="../geo.jsp">Qui sommes-nous</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<h1 class="bleu">Gestion des styles</h1>
		<br> <br>
		<table class="table table-hover table-striped">
			<tr>
				<th><a href="trierStyle?par=iA"><span
						class="glyphicon glyphicon-menu-down"></span></a> id <a
					href="trierStyle?par=iD"><span class="glyphicon glyphicon-menu-up"></span></a></th>
				<th><a href="trierStyle?par=lA"><span
						class="glyphicon glyphicon-menu-down"></span></a> Libelle <a
					href="trierStyle?par=lD"><span class="glyphicon glyphicon-menu-up"></span></a></th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach items="${listeS}" var="s" varStatus="bStatus">
				<form action="modifStyle" method="Post">
					<tr>
						<input type="hidden" name="id" value="${s.id}" />
						<td>${s.id}</td>
						<td><input type="text" name="libelle" value="${s.libelle}" /></td>
						<td class="centre">
							<button type="submit" class="glyphicon glyphicon-edit vert"></button>

						</td>
						<td class="centre">
							<a href="supprimerStyle?index=s${s.id}">
								<span class="glyphicon glyphicon-remove rouge" id="s${s.id}"></span>
							</a>
						</td>
					</tr>
				</form>
			</c:forEach>
		</table>

		<br><br><br>
		<h2 class="bleu">Nouveau style :</h2>
		<div>
			<form:form action="ajouterStyle" method="POST"
				cssClass="form-horizontal" modelAttribute="style">
				<div class="form-group">
					<div class="col-xs-10">
						<form:input path="libelle" placeholder="Libellé du style ..."
							cssClass="form-control" />
					</div>
					<div class="col-xs-2">
						<button type="submit" class="btn btn-primary pull-right">Envoyer</button>			
					</div>
				</div>
				
			</form:form>
		</div>

	</div>
	<nav class="navbar navbar-default navbar-fixed-bottom">
		<div class="container">
			<ul class="nav navbar-nav  navbar-foot">
				<li class="pull-right"><a >yannickroubieu.com</a></li>
			</ul>
		</div>
	</nav>

</body>
</html>