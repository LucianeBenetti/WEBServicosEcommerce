<%@page import="java.util.ArrayList"%>
<%@page import="controle.VO.Item"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <title>LuMar</title>
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

        <h4>Digital LuMar - Confira abaixo os produtos oferecidos pela melhor loja da Internet, 
            ou pesquise por um produto específico</h4>
        <form action="pesquisaritem" method="get">
            Pesquise aqui:
            <input type="text"  size="60" name="descricaoproduto" placeholder="Digite a descrição de um produto!">
            <input type="submit"  value="Pesquisar!"><br><br>

        </form>

    </div>

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
                    <li class="active"><a href="#">Home</a></li>
                    <li><a href="#" onclick="alertaDeCompra()">Comprar</a></li>
                    <li><a href="#">Compromisso</a></li>
                    <li><a href="#">Contato</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#"><span class="glyphicon glyphicon-shopping-cart"></span> Carrinho</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="container">
        <h2>Resultado da Pesquisa!</h2>

        <%

            Object obj = request.getAttribute("itensencontrados");

            String descricaoProduto = null;
            String nome = null;
            Double valor = 0.0;

            if (obj != null) {
                ArrayList<Item> itensEncontrados = (ArrayList<Item>) obj;
                for (int i = 0; i < itensEncontrados.size(); i++) {
                    descricaoProduto = itensEncontrados.get(i).getDescricao();
                    nome = itensEncontrados.get(i).getNome();
                    valor = itensEncontrados.get(i).getValor();

                    if (descricaoProduto.equals(itensEncontrados.get(i).getDescricao())) {

        %>                          
        <div class="row">
            <div class="col-sm-6">
                <div class="panel panel-primary">
                    <div class="panel-heading"><%= nome%></div>
                    <div class="panel-body"><%= descricaoProduto%></div>
                    <div class="panel-footer"><%out.println("R$ " + valor);%></div>
                </div>
            </div>
            <div class="col-sm-6">
                <div>                                    
                    <button type="button" class="btn btn-warning btn-block" onclick="adicionarAoCarro()">Adicionar ao Carrinho</button>
                </div>
            </div>
        </div>                        

        <%
                    } else {
                        out.println("Item não encontrado!");
                    }

                }
            }
        %> 

    </div>
    <footer class="container-fluid text-center">
        &copy; Desenvolvido por Luciane Benetti e Marco Sena.  
    </footer>      
</body>
</html>
