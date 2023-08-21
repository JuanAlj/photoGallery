<!doctype html>
<html>
<head>
    <title>Albums</title>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1" name="viewport">
</head>
<body>
<div class="container">
            <h2>Albums</h2>
    <table class="table">
        <thead >
        <tr>
            <th scope="col">Id</th>
            <th scope="col">Title</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody>
        <#list albums as album>
        <tr>
            <th scope="row">${album.id}</th>
            <td>${album.title}</td>
            <td><a href="/photos/${album.id}">Photos</a></td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>