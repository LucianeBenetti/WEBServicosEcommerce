<%-- 
    Document   : MostrarPedido
    Created on : 31/05/2019, 13:43:32
    Author     : 80130917
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="controle.VO.PedidoCompra"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%
            Object pedidoUsuario = request.getAttribute("pedidoUsuario");
            Object valorTotal = request.getAttribute("valortotal");
            Object valorPedido = request.getAttribute("valorPedido");

            if (pedidoUsuario != null) {
                ArrayList<PedidoCompra> itemPedido = (ArrayList<PedidoCompra>) pedidoUsuario;

        %>   

        <table class="table table-hover">
            <thead>
                <tr>
                    <th>Nome</th>
                    <th>Descrição</th>
                    <th>Preço</th>
                    <th>Qntde</th>
                </tr>
            </thead>
            <tbody>
                <%      for (int i = 0; i < itemPedido.size(); i++) {
                        PedidoCompra pedidoCompra = itemPedido.get(i);
                %>
                <tr>
                    <td><% out.print(pedidoCompra.getItensDePedido().getItem().getNome()); %></td>
                    <td><% out.print(pedidoCompra.getItensDePedido().getItem().getDescricao()); %></td>
                    <td><% out.print(pedidoCompra.getItensDePedido().getItem().getValor());%></td>
                    <td><% out.print(pedidoCompra.getItensDePedido().getQuantidade()); %></td>
                               
                </tr>
                <%}%>
            <br />  

            <tr>
                <td class="total" colspan="2">Total</td>
                <td>R$ <%= valorTotal%></td>
                <td><%= valorPedido%></td>
            </tr>

        </table>
        <%}%>
    </section>

    

</body>
</html>

