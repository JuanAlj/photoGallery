<!doctype html>
<head>
    <title>Freemarker Example</title>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1" name="viewport">
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
          rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
    </script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js">
    </script>
</head>
<body>
<div class="container">
            <h2>User CRUD operation with Freemarker Template</h2>
     <a href="/create" class="btn btn-primary" role="button">Create New User</a>
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
            <td>${album.album}</td>
            <td><a href="/photos/${album.id}" class="btn btn-danger" role="button">Photos</a></td>
        </tr>
        </#list>
        </tbody>
    </table>
</div>
</body>
</html>