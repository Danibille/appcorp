<%@ page import="java.util.List" %>
<%@ page import="model.Editora" %>
<%@ page import="model.Genero" %>
<%@ page import="model.Livro" %>
<%
    Livro livro = (Livro) request.getAttribute("entidade");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Livro Cadastro</title>
</head>
<body>
    <h2><% if (livro != null) { %>Editar Livro<% } else { %>Cadastrar Livro<% } %></h2>
    <form action="<%= request.getAttribute("urlSubmit") %>" method="post">
        <input type="hidden" name="id" value="<%= livro != null ? livro.getId() : '' %>">
        <input type="hidden" name="acao" value="<%= livro != null ? 'editar' : 'cadastrar' %>">

        <label for="titulo">Titulo:</label>
        <input type="text" id="titulo" name="titulo" value="<%= livro != null ? livro.getTitulo() : "" %>" required><br><br>

        <label for="editora">Editora:</label>
        <select name="editoraID" id="editora" multiple size="5" required>
            <% 
                List<Editora> editoras = (List<Editora>) request.getAttribute("editoras");
                if (editoras != null) {
                    for (Editora editora : editoras) {
            %>
                        <option value="<%= editora.getId() %>">
                            <%= editora.getNome() %>
                        </option>
            <%
                    }
                }
            %>
        </select>


        <label for="genero">Genero: </label>
        <select name="generoId" id="genero" multiple size="5" required>
            <%
                List<Genero> generos = (List<Genero>) request.getAttribute("generos");
                if (generos != null){
                for (Genero genero : generos) {
            %>
                <option value="<%= genero.getId() %>">
                    <%= genero.getGenero() %>
                </option>
            <%
                    }
                }
            %>
        </select><br>

        <label for="autor">Autor: </label>
        <input type="text" id="autores" name="autores" value="<%= livro != null ? livro.getAutores() : "" %>" required><br><br>

        <button type="submit"><%= livro != null ? 'Editar Livro' : 'Cadastrar Livro' %></button>


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