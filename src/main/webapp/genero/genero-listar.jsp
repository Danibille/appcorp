<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Genero" %>
<%
    List<Genero> generos = (List<Genero>) request.getAttribute("generos");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Listar Generos</title>
    <style>
        table { border-collapse: collapse; width: 60%; }
        th, td { border: 1px solid #ccc; padding: 8px; text-align: left; }
        th { background: #f2f2f2; }
        a { margin-right: 8px; }
    </style>
</head>
<body>
    <h2>Lista de Generos</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Genero</th>
            <th colspan="2">Ações</th>
        </tr>
        <%
            if (generos != null && !generos.isEmpty()) {
                for (Genero genero : generos) {
        %>
        <tr>
            <td><%= genero.getId() %></td>
            <td><%= genero.getNome() %></td>
            <td>
                <a href="CadastrasGenero?id=<%= genero.getId() %>">Editar</a>
            </td>
            <td>
                <a href="DeletarGenero?id=<%= genero.getId() %>" onclick="return confirm('Tem certeza que deseja remover?');">Remover</a>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="3">Nenhum genero encontrada.</td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>