<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="./bootstrap.min.css" rel="stylesheet" />
<link href="./styles.css" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body>
	<div class="card" style="width: 18rem;margin:5vw;">
	  <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
        <div class="card-body">
	    <h5 class="card-title">Nom : <%= request.getAttribute("name") %></h5>
	    <p class="card-text">Taille : <%= request.getAttribute("taille") %></p>
		<p class="card-text">Chambre(s) : <%= request.getAttribute("chambre") %></p>
		<p class="card-text">Prix : <%= request.getAttribute("price") %> Ariary</p>
		<p class="card-text">Téléphone : <%= request.getAttribute("phone") %></p>
		
  		
  		<form action='./insert' method='post'>
  		<input type='hidden' name='name' value="<%= request.getAttribute("name") %>"/>
   		<input type='hidden' name='taille' value="<%= request.getAttribute("taille") %>"/>
   		<input type='hidden' name='chambre' value="<%= request.getAttribute("chambre") %>"/>
   		<input type='hidden' name='price' value="<%= request.getAttribute("price") %>"/>
   		<input type='hidden'name='phone'  value="<%= request.getAttribute("phone") %>"/>
  	 	<button type="submit" class="btn btn-primary mt-2">Confirmer la vente</button>
   		</form>
  	</div>
  	
  	<!-- 
  	<div class="card">
  <div class="card-header">
    Suggestion
  </div>
  <div class="card-body">
    <h5 class="card-title">On vous suggère un prix de : 19000 Ariary pour ce produit</h5>
   	<form action='./insert' method='post'>
   		<input type='hidden' value=<%= request.getAttribute("name") %>/>
   		<input type='hidden' value=<%= request.getAttribute("taille") %>/>
   		<input type='hidden' value=<%= request.getAttribute("chambre") %>/>
   		<input type='hidden' value=<%= request.getAttribute("price") %>/>
   		<input type='hidden' value=<%= request.getAttribute("phone") %>/>
   		<button type="submit" class="btn btn-primary">J'accepte</button>
   	</form>
   	<form action='./insert' method='post'>
  	 	<button type="submit" class="btn btn-primary mt-2">Je garde mon prix</button>
   	</form>
  </div>
   -->
</div>
</div>
</body>
</html>
