<%@ page import="java.util.List" %>
<%@ page import="model.Bibliotecario" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listar Bibliotecarios</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>Bibliotecarios</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
        <%
            List<Bibliotecario> bibliotecarios = (List<Bibliotecario>) request.getAttribute("bibliotecarios");
            for (Bibliotecario bibliotecario : bibliotecarios) {
        %>
            <tr>
                <td><%= bibliotecario.nome %></td>
                <td><%= bibliotecario.email %></td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>
</body>
</html>