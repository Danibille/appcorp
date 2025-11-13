<%@ page import="java.util.List" %>
<%@ page import="model.Emprestimo" %>
<%@ page import="model.Livro" %>
<%
    Emprestimo emprestimo = (model.Emprestimo) request.getAttribute("emprestimo");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro Emprestimo</title>
</head>
<body>
    <form action="CadastrarEmprestimo" method="post">
        <input type="hidden" name="id" value="<%= emprestimo != null ? emprestimo.getId() : '' %>">
        <input type="hidden" name="acao" value="<%= emprestimo != null ? 'editar' : 'cadastrar' %>">

        <label for="data_emprestimo">Data Emprestimo: </label>
        <input type="text" id="data_emprestimo" name="data_emprestimo" value="<%= emprestimo != null ? emprestimo.getData_empretimo() : '' %>" required><br>

        <label for="livro">Livro: </label>
        <select id="livro" name="livroId" required>
            <%
                List<Livro> livros = (List<Livro>) request.getAttribute("livros");
                for (Livro livro : livros) {
            %>
                <option value="<%= livro.getId() %>" <%= emprestimo != null && emprestimo.getLivro().getId().equals(livro.getId()) ? "selected" : "" %>><%= livro.getTitulo() %></option>
            <%
                }
            %>
        </select><br>

        <button type="submit"><%= emprestimo != null ? 'Editar Emprestimo' : 'Cadastrar Emprestimo' %></button>

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