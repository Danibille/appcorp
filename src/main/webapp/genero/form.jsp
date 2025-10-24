<%@ page import="java.util.List" %>
<%@ page import="model.Genero" %>
<%
    Genero genero = (Genero) request.getAttribute("entidade");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Genero - Formulário</title>
</head>
<body>
    <h2><% if (genero != null) { %>Editar Genero<% } else { %>Cadastrar Genero<% } %></h2>
    <form action="<%= request.getAttribute("urlSubmit") %>" method="post">
        <input type="hidden" name="id" value="<%= genero != null ? genero.getId() : "" %>">
        <input type="hidden" name="acao" value="<%= genero != null ? "editar" : "cadastrar" %>">

        <label for="genero">Genero:</label>
        <input type="text" id="genero" name="genero" value="<%= genero != null ? genero.getGenero() : "" %>" required><br><br>

        <button type="submit"><%= genero != null ? "Editar Genero" : "Cadastrar Genero" %></button>

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