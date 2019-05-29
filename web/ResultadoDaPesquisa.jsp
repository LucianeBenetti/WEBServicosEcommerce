<%-- 
    Document   : ResultadoDaPesquisa
    Created on : 28/05/2019, 15:31:04
    Author     : 80119050
--%>

<%@page import="controle.VO.Item"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado da Pesquisa</title>
    </head>
    <body>
        <h1>Resultado da Pesquisa!</h1>

        <%

            Object obj = request.getAttribute("itensenccontrados");

            String descricaoProduto = null;
            String nome = null;
            Double valor = 0.0;

            if (obj != null) {
                ArrayList<Item> itens = (ArrayList<Item>) obj;
                for (int i = 0; i < itens.size(); i++) {
                    descricaoProduto = itens.get(i).getDescricao();
                    nome = itens.get(i).getNome();
                    valor = itens.get(i).getValor();
                }
                
                out.println(descricaoProduto);
                out.println(nome);
                out.println(valor);
            }

        %>

        
    </body>
</html>
