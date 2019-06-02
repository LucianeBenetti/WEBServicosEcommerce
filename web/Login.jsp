
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <title>LuMar - Loja on-line</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
     
</head>
<body>
    
<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
     
</nav>

    <div class="container">
        <h2>Loja Digital LuMar!</h2>
        <p> Entre com o login e senha para comprar à vontade!</P>
        
        <form class="was-validated" action="crudecommerce" method="post">
            <div class="form-group">
                <label for="nome">Login:</label>
                <input type="text" class="form-control" id="login" placeholder="Digite seu login" name="login" required>
                <div class="valid-feedback">Campo preenchido. Ok!</div>
                <div class="invalid-feedback">Esse campo é obrigatório.</div>
            </div>
            <div class="form-group">
                <label for="pwd">Senha:</label>
                <input type="password" class="form-control" id="senha" placeholder="Digite sua senha" name="senha" required>
                <div class="valid-feedback">Campo preenchido. Ok!</div>
                <div class="invalid-feedback">Esse campo é obrigatório.</div>
                <small id="senha" class="form-text text-muted">Nunca compartilhe a sua senha!</small>

            </div>
            <input type="hidden" id="validar" name="validar" value="validar">
            <button type="submit" class="btn btn-primary">Acessar Loja</button>
            
            <div class="form-group form-check" style =" float: top">
                <label class="form-check-label">
                    <input class="form-check-input" type="checkbox" name="remember"> Lembre-me!
                </label>
            </div> <br>           
            
        </form>
        
        <form class="form-group" action="CadastrarUsuario.jsp" method="post">
            Não sou cadastrado <input type="submit" class="btn btn-primary" value = "Clique aqui!">
        </form>
</div>
    

<div class="jumbotron text-center" style="margin-bottom: 0%; height: 0.5%; padding: 0.5%;">
  <p>&copy; Desenvolvido por Luciane Benetti e Marco Sena.</p>
</div>

</body>
</html>
