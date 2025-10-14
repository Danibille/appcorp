<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editora Form</title>
</head>
<body>
    <form action="Emprestimo" method="post">
        <label for="data_emprestimo">Data do emprestimo:</label><br>
        <input type="text" name="data_emprestimo" id="data_emprestimo"/><br>
        <button type="submit" value="Enviar">Enviar</button>
    </form>

    <style>
        body{
            background-color: purple;
            text-align: center;
        }

        input{
            background-color: #C8A2C8;
            color:white;
            border-radius: 5px;
            padding: 10px;
            margin: 5px;
        }

        label{
            color:white;
        }

        button{
            background-color: #C8A2C8;
            color: white;
            padding: 5px;
            margin: 10px;
        }
    </style>
</body>
</html>