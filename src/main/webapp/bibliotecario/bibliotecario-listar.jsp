<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Bibliotecario" %>
<%
    List<Bibliotecario> bibliotecarios = (List<Bibliotecario>) request.getAttribute("bibliotecarios");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Listar Bibliotecario</title>
    <style>
        table { border-collapse: collapse; width: 60%; }
        th, td { border: 1px solid #ccc; padding: 8px; text-align: left; }
        th { background: #f2f2f2; }
        a { margin-right: 8px; }
    </style>
</head>
<body>
    <h2>Lista de Bibliotecarios</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Bibliotecario</th>
            <th colspan="2">Ações</th>
        </tr>
        <%
            if (bibliotecarios != null && !bibliotecarios.isEmpty()) {
                for (Bibliotecario bibliotecario : bibliotecarios) {
        %>
        <tr>
            <td><%= bibliotecario.getId() %></td>
            <td><%= bibliotecario.getNome() %></td>
            <td>
                <a href="CadastrarBibliotecario?id=<%= genero.getId() %>">Editar</a>
            </td>
            <td>
                <a href="DeletarBibliotecario?id=<%= genero.getId() %>" onclick="return confirm('Tem certeza que deseja remover?');">Remover</a>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="3">Nenhum bibliotecario encontrada.</td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>