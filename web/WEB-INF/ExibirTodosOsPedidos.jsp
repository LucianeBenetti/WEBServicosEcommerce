<%-- 
    Document   : ExibirPedidos
    Created on : 05/06/2019, 15:51:54
    Author     : 80130917
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Exibir Pedidos</title>
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
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="voltarhomeautenticado">Home</a></li>
                        <li><a href="carrinho">Comprar</a></li>
                        <li><a href="maisvendidos">Mais Vendidos</a></li>
                        <li><a href="#">Contato</a></li>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"><span class="glyphicon glyphicon-user"></span>
                                Minha Conta
                            </a>
                            <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                                <a class="dropdown-item" href=".jsp">Listar/Cancelar Pedidos</a><br>
                                <a class="dropdown-item" href="atualizarcartao">Alterar Forma de pagamento</a><br>
                            </div>
                        </li>

                        <li><input class="btn" style="margin: 14px 0px 10px 10px; padding: 0px;"  size="10" type="text" value="<%out.println("Olá " + request.getAttribute("nomeusuario") + "!");%>"></li>
                        <li><a href="carrinho"><span class="glyphicon glyphicon-shopping-cart"></span>Carrinho</a></li>
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
            <%
                Object nomeUsuario = request.getAttribute("nomeusuario");

                if (nomeUsuario != null) {
            %> 

            <form action="" method="get"><br>
                <input type="hidden" id="mostrarpedidosdousuario" name="mostrarpedidosdousuario" value="mostrarpedidosdousuario">
                <input type="submit" class="btn btn-danger" value="Mostrar Pedidos do Usuário">
            </form>


            <%}%>
        </div>
    </body>
</html>
