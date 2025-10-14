<%@ page import="java.util.List" %>
<%@ page import="model.Livro" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listar livro</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>Titulo</th>
                <th>Editora</th>
                <th>Gênero</th>
                <th>Autor</th>
            </tr>
        </thead>
        <tbody>
        <%
            List<Livro> livros = (List<Livro>) request.getAttribute("livros");
            for (Livro livro : livros) {
        %>
            <tr>
                <td><%= livro.getTitulo() %></td>
                <td><%= livro.getEditora().getNome() %></td>
                <td><%= livro.getGenero().getGenero() %></td>
                <td><%= livro.getAutor() %></td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>
</body>
</html>