<%@ page import="java.util.List" %>
<%@ page import="model.Editora" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listar Editoras</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>ID </th>
                <th>Editora</th>
            </tr>
        </thead>
        <tbody>
        <%
            List<Editora> editoras = (List<Editora>) request.getAttribute("editoras");
            for (Editora editora : editoras) {
        %>
            <tr>
                <td><%= editora.getId() %></td>
                <td><%= editora.getNome() %></td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>
</body>
</html>