<%@ page import="java.util.List" %>
<%@ page import="model.Emprestimo" %>
<%@ page import="model.Livro" %>
<%
    Emprestimo emprestimo = (Emprestimo) request.getAttribute("entidade");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Emprestimo Form</title>
</head>
<body>
    <h2><% if (emprestimo != null) { %>Editar Emprestimo<% } else { %>Cadastrar Emprestimo<% } %></h2>
    <form action="<%= request.getAttribute("urlSubmit") %>" method="post">
        <input type="hidden" name="id" value="<%= emprestimo != null ? emprestimo.getId() : '' %>">
        <input type="hidden" name="acao" value="<%= emprestimo != null ? 'editar' : 'cadastrar' %>">

        <label for="data_emprestimo">Data do emprestimo:</label><br>
        <input type="text" name="data_emprestimo" id="data_emprestimo"/><br>

        <label for="livro">Livro:</label>
        <select name="livroId" id="livro" multiple size="5" required>
            <% 
                List<Livro> livros = (List<Livro>) request.getAttribute("livros");
                if (livros != null) {
                    for (Livro livro : livros) {
            %>
                        <option value="<%= livro.getId() %>">
                            <%= livro.getNome() %>
                        </option>
            <%
                    }
                }
            %>
        </select>

        <button type="submit"><%= emprestimo != null ? 'Editar Emprestimo' : 'Cadastrar Emprestimo' %></button>
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