<%@ page import="java.util.List" %>
<%@ page import="model.Editora" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Livro Form</title>
</head>
<body>
    <form action="Livros" method="post">
        <label for="titulo">Titulo:</label><br>
        <input type="text" name="titulo" id="titulo"/><br>
        <label for="editora">Editora</label><br>
        <select id="editoras" name="editoras">
            <option value="">Editoras</option>
            <%
            List<Editora> editoras = (List<Editora>) request.getAttribute("editoras");
            for (Editora editora : editoras) {
        %>
            <option value="<%= editora.getId() %>"><%= editora.getNome() %></option>
        <%
            }
        %>

        <label for="autor">Autor:</label><br>
        <input type="text" name="autor" id="autor"/><br>
        <button type="submit" value="Enviar">Enviar</button>
    </form>

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