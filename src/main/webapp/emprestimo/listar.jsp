<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Emprestimo" %>
<%
    List<Emprestimo> emprestimos = (List<Emprestimo>) request.getAttribute("lista");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Listar Emprestimos</title>
    <style>
        table { border-collapse: collapse; width: 60%; }
        th, td { border: 1px solid #ccc; padding: 8px; text-align: left; }
        th { background: #f2f2f2; }
        a { margin-right: 8px; }
    </style>
</head>
<body>
    <table>
        <tr>
            <th>Data do Emprestimo</th>
            <th>Livro</th>
        </tr>
        <%
            if (emprestimos != null && !emprestimos.isEmpty()) {
                for (Emprestimo emprestimo : emprestimos) {
        %>
        <tr>
            <td><%= emprestimo.data_emprestimo %></td>
            <td><%= emprestimo.getLivro().getTitulo() %></td>
            <td>
                <a href="<%= request.getAttribute("urlSubmit") %>?acao=buscar&id=<%= emprestimo.getId() %>">Editar</a>
            </td>
            <td>
                <a href="<%= request.getAttribute("urlSubmit") %>?acao=deletar&id=<%= emprestimo.getId() %>" onclick="return confirm('Tem certeza que deseja remover?');">Remover</a>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="6">Nenhum emprestimo encontrado.</td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</body>
</html>