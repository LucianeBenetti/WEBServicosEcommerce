<%-- 
    Document   : MeusDados
    Created on : 05/06/2019, 14:10:06
    Author     : 80130917
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Meus Dados</title>
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
        <div class="container">
            <%
                Object nomeUsuario = request.getAttribute("nomeusuario");
                Object numeroCartao = request.getAttribute("numerocartao");
                if (nomeUsuario != null) {
            %> 
            <form action="fecharpedido" method="get"><br>

                <h4>Confira o <b>Número do seu Cartão</b>. Se não estiver correto, digite o novo número e clique em Atualizar Cartão!</h4> <br><br>

                <div class="form-group">
                    <label for="nome">Nome do Usuário:</label>
                    <input type="text" disabled value="<% out.print(nomeUsuario); %>" name="login" class="form-control" id="login" required>
                </div>

                <div class="form-group">
                    <label for="nome">Número do Cartão:</label>
                    <input type="text" value="<% out.print(numeroCartao);%>" name="numerocartao" class="form-control" id="numerocartao" required>
                </div>
                <input type="hidden" id="atualizarcartao" name="atualizarcartao" value="atualizarcartao">
                  <input type="submit" class="btn btn-danger" value="Atualizar Cartão">
            </form>
            <%}%>
        </div>
    </body>
</html>
