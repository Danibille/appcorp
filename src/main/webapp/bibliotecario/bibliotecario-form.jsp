<%@ page import="java.util.List" %>
<%@ page import="model.Bibliotecario" %>
<%
    Bibliotecario bibliotecario = (model.Bibliotecario) request.getAttribute("bibliotecario");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro Bibliotecario</title>
</head>
<body>
    <form action="CadastrarBibliotecario" method="post">
        <input type="hidden" name="id" value="<%= bibliotecario != null ? bibliotecario.getId() : '' %>">
        <input type="hidden" name="acao" value="<%= bibliotecario != null ? 'editar' : 'cadastrar' %>">

        <label for="nome">Nome: </label>
        <input type="text" id="nome" name="nome" value="<%= bibliotecario != null ? bibliotecario.getNome() : '' %>" required><br>

        <label for="email">Email: </label>
        <input type="text" id="email" name="email" value="<%= bibliotecario != null ? bibliotecario.getUsuario.getEmail() : '' %>" required><br>

        <button type="submit"><%= bibliotecario != null ? 'Editar Bibliotecario' : 'Cadastrar Bibliotecario' %></button>

    <style>
        body{
            background-color: purple;
            text-align: center;
        }

        input{
            background-color: #C8A2C8;
            color:white;
            border-radius: 5px;
            padding: 10px;
            margin: 5px;
        }

        label{
            color:white;
        }

        button{
            background-color: #C8A2C8;
            color: white;
            padding: 5px;
            margin: 10px;
        }
    </style>
</body>
</html>