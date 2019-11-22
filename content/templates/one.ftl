<!doctype html>
<html lang="en">
<head>
</head>

<body>
<p>The name is ${name}</p>
<p>My age is ${age}</p>
My skills are:
<list>
    <#list skills as skill>
        <li>
            <p>
                ${skill}
            </p>
        </li>
    </#list>
</list>

<p>JONH</p>
<p>${john.getId()}</p>
<p>${john.getName()}</p>
<p>${john.age}</p>
<p>${john.toString()}</p>

</body>
</html>
