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
            
            if(obj != null){
                ArrayList<Item> itens = (ArrayList<Item>) obj;
                    for(Item item: itens){
                    out.println(itens);               
                                }
            }
        
        %>
        
        <div class="col-sm-4"> 
      <div class="panel panel-danger">
        <div class="panel-heading">Violão Takasena.</div>
        <div class="panel-body"><img src="takamine.jpg" class="img-responsive" style="width:100%" alt="Violão Takamine"></div>
        <div class="panel-footer">Violão Takasena corda de Lynon! Só R$ 15,00.</div>
      </div>
    </div>
    </body>
</html>
