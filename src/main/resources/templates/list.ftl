<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>list</title>
    <script src="../jquery/jquery-1.11.3.min.js"></script>
</head>
<body>
<h1>list页面</h1>
<form id="formId" METHOD="post">
    <input type="hidden" name="_method" value="DELETE">
</form>
<a href="/toAddPage">增加</a>



<table border="1" width="500">
    <tr>
        <td>编号</td>
        <td>用户名</td>
        <td>年龄</td>
        <td>性别</td>
        <td>生日</td>
        <td>操作</td>
    </tr>
<#list list as item>
    <tr>
        <td>${item.id}</td>
        <td>${item.name}</td>
        <td>${item.age}</td>
        <td>
            <#if item.sex==1>
                男
            <#elseif item.sex == 2 >
                女
            </#if>
        </td>
        <td>
            ${item.bir?date}
        </td>

        <td>
            <a href=javascript:deleteById(${item.id})>删除</a>
            <a href="toUpdatePage/${item.id}">修改</a>
        </td>
    </tr>
</#list>
</table>

<script>
    function deleteById(id){
        $("#formId").prop("action","user/"+id);
        $("#formId").submit();
    }
</script>
</body>
</html>