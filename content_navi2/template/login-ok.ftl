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
        Hi, ${name}, you successfully logged in
    </h1>
    <p>Links:</p>
    <list>
        <#list links as link>
        <li><a href="${link.href}">${link.name}</a></li>
        </#list>
    </list>

</body>
</html>
