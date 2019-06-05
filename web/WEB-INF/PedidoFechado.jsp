<%-- 
    Document   : PedidoFechado
    Created on : 04/06/2019, 14:21:53
    Author     : 80119050
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Pedido Fechado</title>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel='stylesheet' href='https://use.fontawesome.com/releases/v5.7.0/css/all.css' integrity='sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ' crossorigin='anonymous'>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
        <script>

        </script>

        <style>
            /* Remove the navbar's default rounded borders and increase the bottom margin */ 
            .navbar {
                margin-bottom: 10px;
                border-radius: 0;
                padding:0px;
            }

            /* Remove the jumbotron's default bottom margin */ 
            .jumbotron {
                margin-bottom: 0;
                padding: 0px;
            }

            /* Add a gray background color and some padding to the footer */
            footer {
                background-color: #f2f2f2;
                color: red;
                padding: 5px;
                margin-top: 35%;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>                        
                    </button>
                    <a class="navbar-brand" style="padding:4px; float: bottom"><i class="fas fa-globe" style="font-size:40px;color:red;"></i></a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <form action="fecharpedido" method="post">
                                <input type="hidden" id="sairdosistema" name="sairdosistema" value="sairdosistema">
                                <input class="btn" type="submit" name="sairdosistema" value="Sair">  
                          </form> 
                      </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container">
         <h1>Seu pedido foi Finalizado! Anote seu cóigo de segurança: </h1>
        <% 
            Object nomeDoUsuario = request.getAttribute("nomedousuario");
            Object codigoSeguranca = request.getAttribute("codigoseguranca");

            if (nomeDoUsuario != null) {
                String nome = (String) nomeDoUsuario;
                String codigo = (String) codigoSeguranca;%>
                
               
                 <h3><b><% out.print(nome);%></b> O seu código de segurança é: <b><% out.print(codigo);%></b> </h3>
                </div>
         <% } %>
              
    </body>
</html>
