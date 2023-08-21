<!DOCTYPE HTML>
<html>
<head>
    <title>Álbumes</title>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1" name="viewport">
</head>
<body>
<div class="container">
            <h2>Álbumes</h2>
            <a href="/">Volver</a>
            <br /><br />
    <table class="table">
        <thead >
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Título</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#list albums as album>
        <tr>
            <th scope="row">${album.id}</th>
            <td>${album.title}</td>
            <td><a href="/photos/${album.id}">Fotos</a></td>
        </tr>
        </#list>
        </tbody>
    </table>
    <br /><br />
    <a href="/">Volver</a>
</div>
</body>
</html>