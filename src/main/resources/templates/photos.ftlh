<!DOCTYPE HTML>
<html>
<head>
    <title>Fotos</title>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1" name="viewport">
</head>
<body>
<div class="container">
            <h2>Fotos en álbum "${albumTitle}"</h2>
            Haz clic en una foto para verla a tamaño completo.
            <br /><br />
            O <a href="/albums">vuelve a los álbumes</a>
            <br /><br />
    <table class="table">
        <thead >
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Título</th>
            <th scope="col">Previsualización</th>
        </tr>
        </thead>
        <tbody>
        <#list photos as photo>
        <tr>
            <th scope="row">${photo.id}</th>
            <td>${photo.title}</td>
            <td><a href=${photo.url} target=”_blank”><img src=${photo.thumbnailUrl}></a></td>
        </tr>
        </#list>
        </tbody>
    </table>
    <br /><br />
    <a href="/albums">Volver</a>
</div>
</body>
</html>