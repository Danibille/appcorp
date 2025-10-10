<%@ page import="java.util.List" %>
<%@ page import="model.Emprestimo" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listar Emprestimos</title>
</head>
<body>
    <table>
        <thead>
            <tr>
                <th>Data do Emprestimo</th>
            </tr>
        </thead>
        <tbody>
        <%
            List<Emprestimo> emprestimos = (List<Emprestimo>) request.getAttribute("emprestimos");
            for (Emprestimo emprestimo : emprestimos) {
        %>
            <tr>
                <td><%= emprestimo.data_emprestimo %></td>
            </tr>
        <%
            }
        %>
        </tbody>
    </table>
</body>
</html>