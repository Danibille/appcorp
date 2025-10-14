<%@ page import="java.util.List" %>
<%@ page import="model.Genero" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listar Genero</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>ID </th>
                <th>Genero</th>
            </tr>
        </thead>
        <tbody>
        <%
            List<Genero> generos = (List<Genero>) request.getAttribute("generos");
            for (Genero genero : generos) {
        %>
            <tr>
                <td><%= genero.id %></td>
                <td><%= genero.genero %></td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>
</body>
</html>