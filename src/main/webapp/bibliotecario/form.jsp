<%@ page import="java.util.List" %>
<%@ page import="model.Bibliotecario" %>
<%
    Bibliotecario bibliotecario = (Bibliotecario) request.getAttribute("entidade");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bibliotecario - Formulário</title>
</head>
<body>
    <h2><% if (bibliotecario != null) { %>Editar Bibliotecario<% } else { %>Cadastrar Bibliotecario<% } %></h2>
    <form action="<%= request.getAttribute("urlSubmit") %>" method="post">
        <input type="hidden" name="id" value="<%= bibliotecario != null ? bibliotecario.getId() : "" %>">
        <input type="hidden" name="acao" value="<%= bibliotecario != null ? "editar" : "cadastrar" %>">

        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" value="<%= bibliotecario != null ? bibliotecario.getNome() : "" %>" required><br><br>

        <label for="email">Email:</label>
        <imput type="text" id="email" name="email" value="<%= bibliotecario != null ? bibliotecario.getEmail() : "" %>" required <br><br> 

        <button type="submit"><%= bibliotecario != null ? "Editar Bibliotecario" : "Cadastrar Bibliotecario" %></button>

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