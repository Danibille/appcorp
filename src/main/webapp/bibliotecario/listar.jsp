<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Bibliotecario" %>
<%

    List<Bibliotecario> bibliotecarios = (List<Bibliotecario>) request.getAttribute("lista");
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
    <h2>Lista de Bibliotecario</h2>
    <a href="<%= request.getAttribute("urlSubmit") %>?acao=novo">Cadastrar Nova Bibliotecario</a>
    <table>
        <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Email</th>
            <th colspan="2">Ações</th>
        </tr>
        <%
            if (bibliotecarios != null && !bibliotecarios.isEmpty()) {
                for (Bibliotecario bibliotecario : bibliotecarios) {
        %>
        <tr>
            <td><%= bibliotecario.getId() %></td>
            <td><%= bibliotecario.getNome() %></td>
            <td><%= bibliotecario.getEmail() %></td>
            <td>
                <a href="<%= request.getAttribute("urlSubmit") %>?acao=buscar&id=<%= bibliotecario.getId() %>">Editar</a>
            </td>
            <td>
                <a href="<%= request.getAttribute("urlSubmit") %>?acao=deletar&id=<%= bibliotecario.getId() %>" onclick="return confirm('Tem certeza que deseja remover?');">Remover</a>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="5">Nenhum Bibliotecario encontrado.</td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>