<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>update</title>
</head>
<body>
    <form action="/user" method="post">
        <input type="hidden" name="_method" value="PUT"/>
        <input type="hidden" name="id" value="${user.id}"/>
        <br>
        name：<input name="name" value="${user.name}">
        <br>
        age:<input name="age" value="${user.age}">
        <br>
            <#if user.sex==1>
                sex:<input type="radio" name="sex" value="1" checked> 男
                    <input type="radio" name="sex" value="2"> 女
            <#elseif user.sex == 2 >
                sex:<input type="radio" name="sex" value="1"> 男
                    <input type="radio" name="sex" value="2" checked> 女
            </#if>
        <br>
        bir:<input type="date" name="bir" value="${user.bir?date}">
        <br>
        <input type="submit">

    </form>



</body>
</html>