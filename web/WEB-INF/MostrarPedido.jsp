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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mostrar Detalhes do Pedido</title>
    </head>
    <body>
        <h4>Detalhes do Pedido</h4>
        <%
            Object pedidoUsuario = request.getAttribute("pedidocompra");
            Object valorTotal = request.getAttribute("valortotal");
            Object quantidade = request.getAttribute("quantidade");
           
            
            out.print(quantidade);
            if (pedidoUsuario != null) {
                ArrayList<Item> itemPedido = (ArrayList<Item>) pedidoUsuario;

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
            <%      for (int i = 0; i < itemPedido.size(); i++) {
                    Item pedidoItem = itemPedido.get(i);
            %>
            <tr>
                <td><% out.print(pedidoItem.getNome()); %></td>
                <td><% out.print(pedidoItem.getDescricao()); %></td>
                <td><% out.print(pedidoItem.getValor());%></td>
                <td><%=quantidade%></td>
            </tr>
            <%}%>

            <br />  

            <tr>
                <td class="total" colspan="2">Total</td>
                <td>R$ <%= valorTotal%></td>
            </tr>

        </table>
        <%}%>
    </section>



</body>
</html>

