<%@ page import="java.util.List" %>
<%@ page import="model.Editora" %>
<%@ page import="model.Genero" %>
<%@ page import="model.Livro" %>
<%
    Livro livro = (model.Livro) request.getAttribute("livro");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Livro Cadastro</title>
</head>
<body>
    <form action="CadastrarLivro" method="post">
        <input type="hidden" name="id" value="<%= livro != null ? livro.getId() : '' %>">
        <input type="hidden" name="acao" value="<%= livro != null ? 'editar' : 'cadastrar' %>">

        <label for="titulo">Título: </label>
        <input type="text" id="titulo" name="titulo" value="<%= livro != null ? livro.getTitulo() : '' %>" required><br>

        <label for="editora">Editora: </label>
        <select id="editora" name="editoraId" required>
            <%
                List<Editora> editoras = (List<Editora>) request.getAttribute("editoras");
                for (Editora editora : editoras) {
            %>
                <option value="<%= editora.getId() %>" <%= livro != null && livro.getEditora().getId().equals(editora.getId()) ? "selected" : "" %>><%= editora.getNome() %></option>
            <%
                }
            %>
        </select><br>

        <label for="genero">Genero: </label>
        <select id="genero" name="generoId" required>
            <%
                List<Genero> generos = (List<Genero>) request.getAttribute("generos");
                for (Genero genero : generos) {
            %>
                <option value="<%= genero.getId() %>" <%= livro != null && livro.getGenero().getId().equals(genero.getId()) ? "selected" : "" %>><%= genero.getGenero() %></option>
            <%
                }
            %>
        </select><br>

        <label for="autor">Autor: </label>
        <input type="text" id="autores" name="autores" value="<%= livro != null ? livro.getAutores() : '' %>" required><br>

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
   