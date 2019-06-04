<%-- 
    Document   : MostrarPedido
    Created on : 31/05/2019, 13:43:32
    Author     : 80130917
--%>

<%@page import="controle.VO.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page import="controle.VO.PedidoCompra"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
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

    <div class="container">
        <body>
            <h2>Detalhes do Pedido</h2>
            <%
                Object pedidoUsuario = request.getAttribute("pedidocompra");
                Object valorTotal = request.getAttribute("valortotal");
                Object quantidades = request.getAttribute("quantidades");
                Object nomeUsuario = request.getAttribute("nomeusuario");
                Object numeroCartao = request.getAttribute("numerocartao");

                if (pedidoUsuario != null) {
                    ArrayList<Item> itemPedido = (ArrayList<Item>) pedidoUsuario;
                    ArrayList<Integer> qtidades = (ArrayList<Integer>) quantidades;

            %>   

            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Descrição</th>
                        <th>Preço do Item</th>
                        <th>Qntde</th>
                    </tr>
                </thead>
                <%      for (int i = 0; i < itemPedido.size(); i++) {
                        Item pedidoItem = itemPedido.get(i);
                        if (qtidades.get(i) > 0) {
                %>
                <tr>
                    <td><% out.print(pedidoItem.getNome()); %></td>
                    <td><% out.print(pedidoItem.getDescricao()); %></td>
                    <td><% out.print(pedidoItem.getValor());%></td>
                    <td><%=qtidades.get(i)%></td>
                </tr>
                <%}
                    }
                %>

                <br />  

                <tr>
                    <td class="total" colspan="2">Total</td>
                    <td>R$ <%= valorTotal%></td>
                </tr>

            </table><br>

            <form action="fecharpedido" method="get"><br>

                <h4>Confira o <b>Número do seu Cartão</b>. Se não estiver correto, digite o novo número e clique em Atualizar Cartão!</h4> <br><br>

                <div class="form-group">
                    <label for="nome">Nome do Usuário:</label>
                    <input type="text" disabled value="<% out.print(nomeUsuario); %>" name="login" class="form-control" id="login" required>
                </div>

                <div class="form-group">
                    <label for="nome">Número do Cartão:</label>
                    <input type="text" value="<% out.print(numeroCartao); %>" name="numerocartao" class="form-control" id="numerocartao" required>
                </div>

                <input type="hidden" id="atualizarcartao" name="atualizarcartao" value="atualizarcartao">
                <button type="submit" class="btn btn-primary">Atualizar Cartão</button>
            </form>

            <form action="fecharpedido" method="get"><br>      
                <input type="hidden" id="fecharpedido" name="fecharpedido" value="fecharpedido">
                <button type="submit" class="btn btn-primary">Fechar Pedido</button>

            </form>
    </div>
    <%}%>

</body>
</html>

