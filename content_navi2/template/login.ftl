<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${header}</title>
</head>
<body>
    <h1>
        ${header}
    </h1>
    <form method="post">
        <input type="text" name="u_name">
        <input type="text" name="u_password">
        <input type="submit" value="Submit">
    </form>
    <p>Links:</p>
    <list>
        <#list links as link>
        <li><a href="${link.href}">${link.name}</a></li>
        </#list>
    </list>

</body>
</html>
