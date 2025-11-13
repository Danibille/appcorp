<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="model.Emprestimo" %>
<%
    List<Emprestimo> emprestimos = (List<Emprestimo>) request.getAttribute("emprestimos");
%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listar Emprestimos</title>
</head>
<body>
    <h2>Lista de Livros</h2>
    <table>
        <tr>
            <th>ID</th>
            <th>Livro</th>
            <th>Data Emprestimo</th>
            <th>Data Devoluçao</th>
            <th colspan="2">Ações</th>
        </tr>
        <%
            if (emprestimos != null && !emprestimos.isEmpty()) {
                for (Emprestimo emprestimo : emprestimos) {
        %>
        <tr>
            <td><%= emprestimo.getId() %></td>
            <td><%= emprestimo.getLivro().getTitulo() %></td>
            <td><%= emprestimo.getData_emprestimo() %></td>
            <td><%= emprestimo.getData_devolucao %></td>
            <td>
                <a href="CadastrarEmprestimo?id=<%= emprestimo.getId() %>">Editar</a>
            </td>
            <td>
                <a href="DeletarEmprestimo?id=<%= emprestimo.getId() %>" onclick="return confirm('Tem certeza que deseja remover?');">Remover</a>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="6">Nenhum Emprestimo encontrado.</td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>