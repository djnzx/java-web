<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <h1>TemplateApp04</h1>
    <h4>template file location: project resources folder/content/templates/template04.ftl</h4>
    <table border="1">
        <#list randoms as random>
            <tr><td>${random}</td></tr>
        </#list>
    </table>
</body>
</html>
