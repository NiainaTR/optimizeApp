<%@ page import="java.util.List" %>
<%@ page import="MyClass.Product" %>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>OPTIPRICE</title>
        <link href="./styles.css" rel="stylesheet" />
    </head>
    <body>
        <!-- Header-->
        <header class="bg-dark py-2" style="height: 60vh;">
            <div class="container px-4 px-lg-5 my-5">
                <div class="text-center text-white" style="display: flex;flex-direction: column; align-items: center; justify-content: center;">
                    <h1 class="display-4 fw-bolder" style="letter-spacing: 10px;">OPTIPRICE</h1>
                    <p class="lead fw-normal text-white-50 mb-0">Optiprice est une plateforme qui optimise votre vente sur l'immobilier.</p>
                	<a class="btn btn-primary" href="./insert.html" style="margin-top:20px">Ajouter votre annonce</a>
                </div>
                
            </div>
            
        </header>
        <!-- Section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                    
                    <!-- Loop for displaying products -->
                    <% 
                    	List<Product> list =  (List<Product>) request.getAttribute("products");
                    	
                        for (Product product : list) {
                    %>  
                        <div class="col mb-5">
                            <div class="card h-100">
                                <!-- Product image-->
                                <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
                                <!-- Product details-->
                                <div class="card-body p-4">
                                    <div class="text-center">
                                        <!-- Product name-->
                                        <h5 class="fw-bolder"><%=product.nom%></h5>
                                        <!-- Product price-->
                                        <p>Taille :<%=product.taille%> pieds carrés</p>
                                        <p>Chambres : <%=product.chambres%></p>
                                        <p>Price : <%=product.price%></p>                                    
                                        <p>Téléphone : <%=product.phone%></p>
                                    </div>
                                </div>
                            </div>
                        </div>  
                    <% 
                        } 
                    %>
                    
                </div>
            </div>
        </section>
        <!-- Footer-->
        <!-- Bootstrap core JS-->
        <script src="./bootstrap.bundle.min.js"></script>
         <!-- Core theme JS-->
        <script src="./scripts.js"></script>
    </body>
</html>
