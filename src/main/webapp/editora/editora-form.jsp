<%@ page import="java.util.List" %>
<%@ page import="model.Editora" %>
<%
    Editora editora = (model.Editora) request.getAttribute("editora");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro Editora</title>
</head>
<body>
    <form action="CadastrarEditora" method="post">
        <input type="hidden" name="id" value="<%= editora != null ? editora.getId() : '' %>">
        <input type="hidden" name="acao" value="<%= editora != null ? 'editar' : 'cadastrar' %>">

        <label for="nome">Nome: </label>
        <input type="text" id="nome" name="nome" value="<%= editora != null ? editora.getNome() : '' %>" required><br>


        <button type="submit"><%= editora != null ? 'Editar Editora' : 'Cadastrar Editora' %></button>

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